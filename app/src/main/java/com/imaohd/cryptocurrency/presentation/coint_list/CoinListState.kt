package com.imaohd.cryptocurrency.presentation.coint_list

import com.imaohd.cryptocurrency.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
