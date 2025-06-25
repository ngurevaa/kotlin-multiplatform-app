package ru.kpfu.itis.kmp.feature.search.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class SaleInfo(
    val buyLink: String? = null,
    val country: String? = null,
    val isEbook: Boolean? = null,
    val listPrice: ListPrice? = null,
    val offers: List<Offer>? = null,
    val retailPrice: RetailPriceX? = null,
    val saleability: String? = null
)
