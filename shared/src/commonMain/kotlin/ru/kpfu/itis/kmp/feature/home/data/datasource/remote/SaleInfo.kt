package ru.kpfu.itis.kmp.feature.home.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class SaleInfo(
    val country: String? = null,
    val isEbook: Boolean? = null,
    val saleability: String? = null
)
