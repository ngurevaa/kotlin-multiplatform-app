package ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class Dimensions(
    val height: String? = null,
    val thickness: String? = null,
    val width: String? = null
)
