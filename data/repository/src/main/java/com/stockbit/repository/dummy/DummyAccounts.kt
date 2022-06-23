package com.stockbit.repository.dummy

import com.stockbit.model.entity.accounts.AccountView
import java.util.*

object DummyAccounts {
    fun getAccounts() : List<AccountView> {
        val user = AccountView(
            id = UUID.randomUUID().toString(),
            username = "user",
            email = "user@mail.com",
            phone = "082231314567",
            password = "12345"
        )

        val jhondoe = AccountView(
            id = UUID.randomUUID().toString(),
            username = "jhondoe",
            email = "jhondoe@mail.com",
            phone = "082231314567",
            password = "12345"
        )
        return arrayListOf(user, jhondoe)
    }

}