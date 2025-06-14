package ru.kpfu.itis.kmp.feature.home.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class ReadingModes(
    val image: Boolean? = null,
    val text: Boolean? = null
)
