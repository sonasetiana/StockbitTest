package com.stockbit.remote.datasource

import com.stockbit.model.entity.crypto.WatchlistEntity
import com.stockbit.remote.home.CryptoService
import com.stockbit.remote.network.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CryptoDataSourceImpl(
    private val service: CryptoService
) : CryptoDataSource{
    override suspend fun getListCrypto(
        page: Int,
        limit: Int
    ): Flow<BaseResponse<List<WatchlistEntity>>>  = flow{
        try {
            emit(service.getListCrypto(page, limit))
        } catch (e: Exception) {
            emit(BaseResponse(e.message.orEmpty(), null))
        }
    }.flowOn(Dispatchers.IO)
}