package com.imaohd.cryptocurrency.data.repository

import com.imaohd.cryptocurrency.data.remote.CoinPaprikaApi
import com.imaohd.cryptocurrency.data.remote.dto.CoinDetailDto
import com.imaohd.cryptocurrency.data.remote.dto.CoinDto
import com.imaohd.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}