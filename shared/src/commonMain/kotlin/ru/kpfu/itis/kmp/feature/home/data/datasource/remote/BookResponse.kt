package ru.kpfu.itis.kmp.feature.home.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    val items: List<Item>? = null,
    val kind: String? = null,
    val totalItems: Int? = null
)
