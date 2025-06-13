package ru.kpfu.itis.kmp.feature.home.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class Pdf(
    val acsTokenLink: String? = null,
    val isAvailable: Boolean? = null
)
