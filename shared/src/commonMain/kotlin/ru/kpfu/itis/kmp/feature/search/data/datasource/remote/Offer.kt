package ru.kpfu.itis.kmp.feature.search.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class Offer(
    val finskyOfferType: Int? = null,
    val listPrice: ListPriceX? = null,
    val retailPrice: RetailPrice? = null
)
