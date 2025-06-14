package ru.kpfu.itis.kmp.feature.home.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class BookApiResponse(
    val items: List<Item> = listOf(),
    val kind: String? = null,
    val totalItems: Int? = null
)
