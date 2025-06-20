package ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class Pdf(
    val isAvailable: Boolean? = null
)
