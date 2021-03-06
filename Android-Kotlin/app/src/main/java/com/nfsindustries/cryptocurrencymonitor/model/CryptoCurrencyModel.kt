package com.nfsindustries.cryptocurrencymonitor.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nfsindustries.cryptocurrencymonitor.utils.TextFormatter

class CryptoCurrencyModel {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("symbol")
    @Expose
    var symbol: String? = null
    @SerializedName("rank")
    @Expose
    var rank: Int = 0
    @SerializedName("price_usd")
    @Expose
    var priceUsd: Float = 0.toFloat()
    @SerializedName("price_btc")
    @Expose
    var priceBtc: Float = 0.toFloat()
    @SerializedName("24h_volume_usd")
    @Expose
    var volumeUsd24h:Float = 0.toFloat()
    @SerializedName("market_cap_usd")
    @Expose
    var marketCapUsd: Float = 0.toFloat()
    @SerializedName("available_supply")
    @Expose
    var availableSupply: Float = 0.toFloat()
    @SerializedName("total_supply")
    @Expose
    var totalSupply: Float = 0.toFloat()
    @SerializedName("percent_change_1h")
    @Expose
    var percentChange1h: Float = 0.toFloat()
    @SerializedName("percent_change_24h")
    @Expose
    var percentChange24h: Float = 0.toFloat()
    @SerializedName("percent_change_7d")
    @Expose
    var percentChange7d: Float = 0.toFloat()
    @SerializedName("last_updated")
    @Expose
    var lastUpdated: Long = 0

    override fun toString(): String {
        val displayStrBuilder = StringBuilder("1 " + name + " to USD\n\n")
        displayStrBuilder.append("Last: " + TextFormatter.formatCurrency(priceUsd) + "\n\n")
        displayStrBuilder.append("Change 1h: " + percentChange1h + "%\n\n")
        displayStrBuilder.append("Change 24h: " + percentChange24h + "%\n\n")
        displayStrBuilder.append("Change 7d: " + percentChange7d + "%\n\n")
        return displayStrBuilder.toString()
    }

}