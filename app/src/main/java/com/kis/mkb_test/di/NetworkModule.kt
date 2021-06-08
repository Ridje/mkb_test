package com.kis.mkb_test.di

import com.kis.mkb_test.network.AssetsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideJacksonBuilder() : Converter.Factory = JacksonConverterFactory.create()

    @Singleton
    @Provides
    fun provideOkHTTPClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Singleton
    @Provides
    fun provideRatesService(converterFactory: Converter.Factory, okHttpClient: OkHttpClient): AssetsAPI {
        return Retrofit
            .Builder()
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .baseUrl(AssetsAPI.baseURL)
            .build()
            .create(AssetsAPI::class.java)
    }

}