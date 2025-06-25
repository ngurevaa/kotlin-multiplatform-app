package ru.kpfu.itis.kmp.feature.search.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class Epub(
    val acsTokenLink: String? = null,
    val isAvailable: Boolean? = null
)
