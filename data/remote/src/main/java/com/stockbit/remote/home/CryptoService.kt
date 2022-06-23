package com.stockbit.remote.home

import com.stockbit.model.entity.crypto.WatchlistEntity
import com.stockbit.remote.network.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoService {
    @GET("data/top/totaltoptiervolfull")
    suspend fun getListCrypto(
        @Query("page") page: Int = 0,
        @Query("limit") limit: Int = 20,
        @Query("tsym") tsym: String = "USD"
    ): BaseResponse<List<WatchlistEntity>>
}