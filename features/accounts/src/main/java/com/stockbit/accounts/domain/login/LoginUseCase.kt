package com.stockbit.accounts.domain.login

import com.stockbit.model.Account
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow

interface LoginUseCase {
    fun initAccounts()
    fun doLogin(
        usernameOrEmail: String,
        password: String
    ) : Flow<Resource<Account>>
}