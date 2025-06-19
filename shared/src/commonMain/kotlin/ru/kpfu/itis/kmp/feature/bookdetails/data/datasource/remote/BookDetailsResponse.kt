package ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class BookDetailsResponse(
    val accessInfo: AccessInfo? = null,
    val etag: String? = null,
    val id: String? = null,
    val kind: String? = null,
    val saleInfo: SaleInfo? = null,
    val selfLink: String? = null,
    val volumeInfo: VolumeInfo? = null
)
