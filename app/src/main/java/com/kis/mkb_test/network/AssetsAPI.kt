package com.kis.mkb_test.network

import com.kis.mkb_test.model.dto.Assets
import retrofit2.Call
import retrofit2.http.*

interface AssetsAPI {

    companion object {
        val baseURL = "https://alpha.as50464.net:29870"
    }

    @Headers(
        "User-Agent: Test GeekBrains iOS 3.0.0.182 (iPhone 11; iOS 14.4.1; Scale/2.00; Private)",
        "Content-Type: application/json",
        "Accept: application/json")
    @POST("moby-pre-44/core")
    fun assetsExchangeRates(
        @Query("r") r : String = "BEYkZbmV",
        @Query("d") d : String = "563B4852-6D4B-49D6-A86E-B273DD520FD2",
        @Query("t") t : String = "ExchangeRates",
        @Query("v") v : String = "44",
        @Field("uid") uid : String = "563B4852-6D4B-49D6-A86E-B273DD520FD2",
        @Field("type") type : String = "ExchangeRates",
        @Field("rid") rid : String = "BEYkZbmV") : Call<Assets>
}