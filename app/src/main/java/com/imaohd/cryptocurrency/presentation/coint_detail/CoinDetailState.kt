package com.imaohd.cryptocurrency.presentation.coint_detail

import com.imaohd.cryptocurrency.domain.model.Coin
import com.imaohd.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
