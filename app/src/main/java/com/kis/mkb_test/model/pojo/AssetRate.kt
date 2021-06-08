package com.kis.mkb_test.model.pojo

import android.icu.math.BigDecimal
import com.kis.mkb_test.model.dto.AssetRate

data class AssetRate(
    val tp: Int,
    val name: String,
    val from: Int,
    val currMnemFrom: String,
    val to: Int,
    val currMnemTo: String,
    val basic: Int,
    val buy: BigDecimal,
    val sale: BigDecimal,
    val deltaBuy: BigDecimal,
    val deltaSale: BigDecimal
) {
    constructor(assetRateDTO : AssetRate) : this (assetRateDTO.tp,
        assetRateDTO.name,
        assetRateDTO.from,
        assetRateDTO.currMnemFrom,
        assetRateDTO.to,
        assetRateDTO.currMnemTo,
        assetRateDTO.basic,
        assetRateDTO.buy,
        assetRateDTO.sale,
        assetRateDTO.deltaBuy,
        assetRateDTO.deltaSale)
}
