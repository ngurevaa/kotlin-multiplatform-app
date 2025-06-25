package ru.kpfu.itis.kmp.feature.search.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class ListPriceX(
    val amountInMicros: Long? = null,
    val currencyCode: String? = null
)
