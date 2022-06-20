package com.lobordi.cryptocurrency.data.repository

import com.lobordi.cryptocurrency.data.remote.CoinPaprikaApi
import com.lobordi.cryptocurrency.data.remote.dto.CoinDetailDto
import com.lobordi.cryptocurrency.data.remote.dto.CoinDto
import com.lobordi.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}