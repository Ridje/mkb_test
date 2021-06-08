package com.kis.mkb_test.repository

import android.accounts.NetworkErrorException
import com.kis.mkb_test.model.dto.Asset
import com.kis.mkb_test.network.AssetsAPI
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
object RepositoryNetwork : Repository {

    @Inject
    lateinit var api : AssetsAPI

    override fun getAssetsExchangeRates(): List<Asset> {
        val result  = api.assetsExchangeRates().execute()

        return when {
            result.isSuccessful -> result.body()?.rates ?: ArrayList()
            else -> throw NetworkErrorException()
        }
    }
}