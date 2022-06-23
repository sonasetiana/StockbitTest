package com.stockbit.repository.repository.home

import com.stockbit.model.entity.crypto.Watchlist
import com.stockbit.remote.datasource.CryptoDataSource
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(
    private val dataSource: CryptoDataSource
) : HomeRepository{
    override fun getListCrypto(page: Int, limit: Int): Flow<Resource<List<Watchlist>>> = flow {
        emit(Resource.loading(null))
        dataSource.getListCrypto(page, limit)
            .collect {
                if(it.isSuccess){
                    val data = (it.data ?: emptyList()).map { entity -> Watchlist(entity) }
                    emit(Resource.success(data))
                }else {
                    emit(Resource.error(Throwable(message = it.message.orEmpty()),null))
                }
            }
    }
}