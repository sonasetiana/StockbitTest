package com.stockbit.repository.repository.accounts

import com.stockbit.local.datasource.AccountDataSource
import com.stockbit.model.Account
import com.stockbit.repository.AppDispatchers
import com.stockbit.repository.dummy.DummyAccounts
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.*

class AccountsRepositoryImpl(
    private val dispatcher: AppDispatchers,
    private val dataSource: AccountDataSource
) : AccountsRepository{
    override suspend fun setupAccounts() {
        dataSource.saveAccountList(DummyAccounts.getAccounts())
    }

    override suspend fun doLogin(
        usernameOrEmail: String,
        password: String
    ): Flow<Resource<Account>> = flow {
        emit(Resource.loading(null))
        dataSource.findAccount(usernameOrEmail, password)
            .flowOn(dispatcher.io)
            .collect {
                if(it.isNullOrEmpty()){
                    emit(Resource.error(error = Throwable(message = "Username or email and password not valid"), data = null))
                }else {
                    emit(Resource.success(it[0]))
                }
            }
    }
}