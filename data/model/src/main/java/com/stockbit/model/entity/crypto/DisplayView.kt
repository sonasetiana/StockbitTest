package com.stockbit.model.entity.crypto

import java.io.Serializable

data class DisplayView(
    val market: String,
    val price: String,
) : Serializable {

    constructor(entity: DisplayEntity?) : this(
        market = entity?.market.orEmpty(),
        price = entity?.price.orEmpty(),
    )

}