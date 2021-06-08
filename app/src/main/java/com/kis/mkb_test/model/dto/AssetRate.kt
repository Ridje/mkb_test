package com.kis.mkb_test.model.dto

import android.icu.math.BigDecimal
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder(
    "tp",
    "name",
    "from",
    "currentMnemFrom",
    "to",
    "currMnemTo",
    "basic",
    "buy",
    "sale",
    "deltaBuy",
    "deltaSale"
)
data class AssetRate(
    @JsonProperty("tp") val tp : Int,
    @JsonProperty("name") val name :  String,
    @JsonProperty("from") val from : Int,
    @JsonProperty("currMnemFrom") val currMnemFrom : String,
    @JsonProperty("to") val to : Int,
    @JsonProperty("currMnemTo") val currMnemTo : String,
    @JsonProperty("basic") val basic : Int,
    @JsonProperty("buy") val buy : BigDecimal,
    @JsonProperty("sale") val sale : BigDecimal,
    @JsonProperty("deltaBuy") val deltaBuy : BigDecimal,
    @JsonProperty("deltaSale") val deltaSale : BigDecimal)
