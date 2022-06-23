package com.stockbit.model.entity.crypto


import com.google.gson.annotations.SerializedName

data class DisplayEntity(
    @SerializedName("MARKET")
    val market: String?,
    @SerializedName("PRICE")
    val price: String?,
)