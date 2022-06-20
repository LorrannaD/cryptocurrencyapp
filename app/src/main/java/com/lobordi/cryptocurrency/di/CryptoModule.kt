package com.lobordi.cryptocurrency.di

import com.lobordi.cryptocurrency.common.Constants.BASE_URL
import com.lobordi.cryptocurrency.data.remote.CoinPaprikaApi
import com.lobordi.cryptocurrency.data.repository.CoinRepositoryImpl
import com.lobordi.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CryptoModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api : CoinPaprikaApi) : CoinRepository {
        return CoinRepositoryImpl(api)
    }
}