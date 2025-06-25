package ru.kpfu.itis.kmp.feature.search.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class ListPrice(
    val amount: Double? = null,
    val currencyCode: String? = null
)
