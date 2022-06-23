package com.stockbit.home.domain

import com.stockbit.model.entity.crypto.Watchlist
import com.stockbit.repository.repository.home.HomeRepository
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow

class HomeInteractor(
    private val repository: HomeRepository
) : HomeUseCase {
    override fun getListCrypto(page: Int, limit: Int): Flow<Resource<List<Watchlist>>> {
        return repository.getListCrypto(page, limit)
    }
}