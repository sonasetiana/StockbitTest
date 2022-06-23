package com.stockbit.model.entity.crypto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WatchlistEntity(

    @SerializedName("CoinInfo")
    val coinInfo: CoinInfoEntity?,

    @SerializedName("DISPLAY")
    val display: WatchlistDisplayEntity?

): Serializable

data class WatchlistDisplayEntity(

    @SerializedName("USD")
    val usd: DisplayEntity?

): Serializable