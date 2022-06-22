package com.stockbit.repository.dummy

import com.stockbit.model.Account
import java.util.*

object DummyAccounts {
    fun getAccounts() : List<Account> {
        val one = Account(
            id = UUID.randomUUID().toString(),
            username = "oliverking",
            email = "oliverking@gmail.com",
            phone = "082231314567",
            password = "qwerty123"
        )

        val two = Account(
            id = UUID.randomUUID().toString(),
            username = "oliverking",
            email = "oliverking@gmail.com",
            phone = "082231314567",
            password = "qwerty123"
        )
        return arrayListOf(one, two)
    }

}