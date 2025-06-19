package ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class IndustryIdentifier(
    val identifier: String? = null,
    val type: String? = null
)
