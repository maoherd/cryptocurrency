package com.imaohd.cryptocurrency.domain.use_case.get_coin

import com.imaohd.cryptocurrency.common.Resource
import com.imaohd.cryptocurrency.data.remote.dto.toCoin
import com.imaohd.cryptocurrency.data.remote.dto.toCoinDetail
import com.imaohd.cryptocurrency.domain.model.Coin
import com.imaohd.cryptocurrency.domain.model.CoinDetail
import com.imaohd.cryptocurrency.domain.repository.CoinRepository
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {

        try {

            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))

        } catch (e: HttpException){

            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException){

            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}