package com.stockbit.local.pref

import com.stockbit.model.entity.accounts.AccountView

interface DataPreference {
    fun saveAccount(account: AccountView)

    fun getAccount(): AccountView?

    fun removeAccount()
}