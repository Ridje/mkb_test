package com.kis.mkb_test.repository

import com.kis.mkb_test.model.dto.AssetRate

interface Repository {
    fun getAssetsExchangeRates() : List<AssetRate>
}