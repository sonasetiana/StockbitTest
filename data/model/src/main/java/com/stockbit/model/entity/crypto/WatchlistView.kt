package com.stockbit.model.entity.crypto

import java.io.Serializable

data class Watchlist(
    val coinInfo: CoinInfoView,
    val display: WatchlistDisplay
): Serializable {

    constructor(entity: WatchlistEntity?) : this(
        coinInfo = CoinInfoView(entity?.coinInfo),
        display = WatchlistDisplay(entity?.display)
    )

}

data class WatchlistDisplay(val usd: DisplayView): Serializable {

    constructor(entity: WatchlistDisplayEntity?) : this(DisplayView(entity?.usd))

}