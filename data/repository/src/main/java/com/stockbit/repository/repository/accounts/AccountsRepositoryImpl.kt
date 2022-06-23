package com.stockbit.repository.repository.accounts

import com.stockbit.local.datasource.AccountDataSource
import com.stockbit.model.entity.accounts.AccountView
import com.stockbit.repository.AppDispatchers
import com.stockbit.repository.dummy.DummyAccounts
import com.stockbit.repository.repository.BaseRepository
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AccountsRepositoryImpl(
    private val dispatcher: AppDispatchers,
    private val dataSource: AccountDataSource
) : BaseRepository(), AccountsRepository{
    override fun setupAccounts() {
        launch {
            dataSource.getTotalAccount()
                .collect{ total ->
                    if(total == 0){
                        dataSource
                            .saveAccountList(DummyAccounts.getAccounts())
                    }
                }
        }

    }

    override fun doLogin(
        usernameOrEmail: String,
        password: String
    ): Flow<Resource<AccountView>> = flow {
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