package com.kis.mkb_test.model.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder(
    "code",
    "messageTitle",
    "message",
    "rid",
    "downloadDate",
    "rates",
    "productState",
    "ratesDate")
data class Assets(
    @JsonProperty("code") val code : Int,
    @JsonProperty("messageTitle") val messageTitle : String,
    @JsonProperty("message") val message : String,
    @JsonProperty("rid") val rid : String,
    @JsonProperty("downloadDate") val downloadDate : String,
    @JsonProperty("rates") val rates : List<Asset>,
    @JsonProperty("productState") val productState : Int,
    @JsonProperty("ratesDate") val ratesDate : String)
