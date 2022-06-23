package com.stockbit.remote.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BaseResponse<out Data>(

    @field:SerializedName("Message")
    val message: String?,

    @field:SerializedName("Data")
    val data: Data?

): Serializable {

    val isSuccess: Boolean
        get() = message == "Success"

}