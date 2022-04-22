package com.imaohd.cryptocurrency.domain.use_case.get_coins

import com.imaohd.cryptocurrency.common.Resource
import com.imaohd.cryptocurrency.data.remote.dto.toCoin
import com.imaohd.cryptocurrency.domain.model.Coin
import com.imaohd.cryptocurrency.domain.repository.CoinRepository
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {

        try {

            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))

        } catch (e: HttpException){

            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException){

            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))
        }
    }
}