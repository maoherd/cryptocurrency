package com.imaohd.cryptocurrency.domain.repository

import com.imaohd.cryptocurrency.data.remote.dto.CoinDetailDto
import com.imaohd.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}