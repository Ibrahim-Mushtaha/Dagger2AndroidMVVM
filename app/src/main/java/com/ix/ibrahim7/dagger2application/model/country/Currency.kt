package com.ix.ibrahim7.dagger2application.model.country


import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("code")
    val code: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)