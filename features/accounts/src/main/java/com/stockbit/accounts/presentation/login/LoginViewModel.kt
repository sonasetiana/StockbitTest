package com.stockbit.accounts.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.stockbit.accounts.domain.login.LoginUseCase
import com.stockbit.common.base.BaseViewModel
import com.stockbit.model.entity.accounts.AccountView
import com.stockbit.repository.utils.Resource

class LoginViewModel(
    private val useCase: LoginUseCase
) : BaseViewModel() {

    fun initAccounts() {
        useCase.initAccounts()
    }

    fun doLogin(
        usernameOrEmail: String,
        password: String
    ) : LiveData<Resource<AccountView>> {
        return useCase.doLogin(usernameOrEmail, password).asLiveData()
    }

    val isLogin : Boolean = useCase.isLogin
}