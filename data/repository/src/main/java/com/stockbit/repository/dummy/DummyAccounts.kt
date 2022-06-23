package com.stockbit.repository.dummy

import com.stockbit.model.entity.accounts.AccountView
import java.util.*

object DummyAccounts {
    fun getAccounts() : List<AccountView> {
        val one = AccountView(
            id = UUID.randomUUID().toString(),
            username = "oliverking",
            email = "oliverking@gmail.com",
            phone = "082231314567",
            password = "qwerty123"
        )

        val two = AccountView(
            id = UUID.randomUUID().toString(),
            username = "oliverking",
            email = "oliverking@gmail.com",
            phone = "082231314567",
            password = "qwerty123"
        )
        return arrayListOf(one, two)
    }

}