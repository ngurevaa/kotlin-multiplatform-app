package ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class ImageLinks(
    val extraLarge: String? = null,
    val large: String? = null,
    val medium: String? = null,
    val small: String? = null,
    val smallThumbnail: String? = null,
    val thumbnail: String? = null
)
