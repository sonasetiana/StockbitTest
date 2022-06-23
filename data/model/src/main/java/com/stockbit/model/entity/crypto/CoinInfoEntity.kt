package com.stockbit.model.entity.crypto


import com.google.gson.annotations.SerializedName

data class CoinInfoEntity(
    @SerializedName("Id")
    val id: String?,
    @SerializedName("Name")
    val name: String?,
)