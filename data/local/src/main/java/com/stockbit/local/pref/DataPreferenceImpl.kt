package com.stockbit.local.pref

import android.content.SharedPreferences
import com.google.gson.Gson
import com.stockbit.model.entity.accounts.AccountView

class DataPreferenceImpl(
    private val pref: SharedPreferences,
    private val gson: Gson
) : DataPreference {

    companion object {
        private const val ACCOUNT = "account"
    }

    override fun saveAccount(account: AccountView) {
        val data = gson.toJson(account)
        pref.edit().putString(ACCOUNT, data).apply()
    }

    override fun getAccount(): AccountView? {
        val data = pref.getString(ACCOUNT, null)
        if (data.isNullOrBlank()) return null
        return try {
            gson.fromJson(data, AccountView::class.java)
        } catch (e: Exception) {
            null
        }
    }

    override fun removeAccount() {
        pref.edit().remove(ACCOUNT).apply()
    }


}