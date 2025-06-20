package ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class Epub(
    val isAvailable: Boolean? = null
)
