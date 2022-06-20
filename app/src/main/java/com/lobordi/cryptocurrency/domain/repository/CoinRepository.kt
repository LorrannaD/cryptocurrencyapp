package com.lobordi.cryptocurrency.domain.repository

import com.lobordi.cryptocurrency.data.remote.dto.CoinDetailDto
import com.lobordi.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId : String): CoinDetailDto
}