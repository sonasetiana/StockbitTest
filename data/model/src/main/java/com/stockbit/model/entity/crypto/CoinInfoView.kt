package com.stockbit.model.entity.crypto

import java.io.Serializable

data class CoinInfoView(
    val id: String,
    val name: String,
) : Serializable {

    constructor(entity: CoinInfoEntity?) : this(
        id = entity?.id.orEmpty(),
        name = entity?.name.orEmpty(),
    )

}