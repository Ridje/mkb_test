package com.kis.mkb_test.network

import com.kis.mkb_test.model.dto.AssetRates
import retrofit2.Call
import retrofit2.http.*

interface AssetsAPI {

    companion object {
        const val baseURL = "https://alpha.as50464.net:29870"
    }

    @Headers(
        "User-Agent: Test GeekBrains iOS 3.0.0.182 (iPhone 11; iOS 14.4.1; Scale/2.00; Private)",
        "Content-Type: application/json",
        "Accept: application/json")
    @POST("moby-pre-44/core")
    fun assetsExchangeRates(
        @Query("r") r : String,
        @Query("d") d : String,
        @Query("t") t : String,
        @Query("v") v : String,
        @Body fields : Map<String, String>) : Call<AssetRates>
}