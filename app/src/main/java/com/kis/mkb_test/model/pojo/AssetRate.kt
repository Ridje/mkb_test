package com.kis.mkb_test.model.pojo

import android.icu.math.BigDecimal
import android.os.Parcelable
import com.kis.mkb_test.model.dto.AssetRate
import kotlinx.android.parcel.Parcelize

@Parcelize
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
) : Parcelable {
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
