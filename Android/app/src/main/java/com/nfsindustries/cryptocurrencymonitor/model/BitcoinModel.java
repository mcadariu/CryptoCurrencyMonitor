package com.nfsindustries.cryptocurrencymonitor.model;

/**
 * Created by maxmouse on 18/5/2017.
 */

public class BitcoinModel {

    private final String id;
    private final String destinationCurrency;
    private final String destSymbol;
    private final float last15m;
    private final float last;
    private final float sell;
    private final float buy;

    //private final boolean isGoingUp;
    //TODO ADD CURRENCY STATUS, if it is going up or down

    public BitcoinModel(String destSymbol, String id, String destinationCurrency, float last15m,
                        float last, float sell, float buy) {
        this.id = id;
        this.last15m = last15m;
        this.destinationCurrency = destinationCurrency;
        this.last = last;
        this.sell = sell;
        this.buy = buy;
        this.destSymbol = destSymbol;
    }

    public String getId() {
        return id;
    }

    public float getLast15m() {
        return last15m;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public float getLast() {
        return last;
    }

    public float getSell() {
        return sell;
    }

    public float getBuy() {
        return buy;
    }

    public String getDestinationSymbol() {
        return destSymbol;
    }

    @Override
    public String toString() {
        return "1" + id + " to " + destinationCurrency + ": " + last;
    }
}