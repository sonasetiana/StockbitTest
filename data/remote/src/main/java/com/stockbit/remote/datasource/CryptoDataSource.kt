package com.stockbit.remote.datasource

import com.stockbit.model.entity.crypto.WatchlistEntity
import com.stockbit.remote.network.BaseResponse
import kotlinx.coroutines.flow.Flow

interface CryptoDataSource {
    suspend fun getListCrypto(page: Int, limit: Int) : Flow<BaseResponse<List<WatchlistEntity>>>
}