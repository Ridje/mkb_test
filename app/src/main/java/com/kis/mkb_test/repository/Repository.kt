package com.kis.mkb_test.repository

import com.kis.mkb_test.model.dto.Asset

interface Repository {
    fun getAssetsExchangeRates() : List<Asset>
}