package com.kis.mkb_test.repository

import com.kis.mkb_test.model.dto.AssetRate
import com.kis.mkb_test.network.AssetsAPI

class RepositoryNetwork(val api : AssetsAPI) : Repository {

    override fun getAssetsExchangeRates(): List<AssetRate> {
        val sendData = mapOf(
            "uid" to "563B4852-6D4B-49D6-A86E-B273DD520FD2",
            "type" to "ExchangeRates",
            "rid" to "BEYkZbmV"
            )
        val result  = api.assetsExchangeRates("BEYkZbmV",
            "563B4852-6D4B-49D6-A86E-B273DD520FD2",
            "ExchangeRates",
            "44",
            sendData).execute()

        return when {
            result.isSuccessful -> result.body()?.rates ?: listOf()
            else -> listOf()
        }
    }
}