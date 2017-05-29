package com.nfsindustries.cryptocurrencymonitor.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by maxmo on 29/5/2017.
 */

public class CachingControlInterceptor implements Interceptor {
    Context context = null;

    public void setContext(final Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(final Chain chain) throws IOException {
        Request request = chain.request();
        boolean isConnected = false;

        try {
            final ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            final NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
        } catch (NullPointerException exception) {
            Log.e("CHECKING_CONNECTION", exception.toString());
        }

        // Add Cache Control only for GET methods
        if (request.method().equals("GET")) {
            if (isConnected) {
                // 1 day
                request = request.newBuilder()
                        .header("Cache-Control", "only-if-cached")
                        .build();
            } else {
                // 4 weeks stale
                request = request.newBuilder()
                        .header("Cache-Control", "public, max-stale=2419200")
                        .build();
            }
        }

        final Response originalResponse = chain.proceed(request);
        return originalResponse.newBuilder()
                .header("Cache-Control", "max-age=600")
                .build();
    }
}