package com.stockbit.repository.repository.accounts

import com.stockbit.model.entity.accounts.AccountView
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AccountsRepository {
    fun setupAccounts()
    fun doLogin(usernameOrEmail: String, password: String) : Flow<Resource<AccountView>>
    val isLogin : Boolean
}