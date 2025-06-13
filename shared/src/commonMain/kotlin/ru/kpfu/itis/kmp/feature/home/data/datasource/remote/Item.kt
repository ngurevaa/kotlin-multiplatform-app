package ru.kpfu.itis.kmp.feature.home.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val accessInfo: AccessInfo? = null,
    val etag: String? = null,
    val id: String? = null,
    val kind: String? = null,
    val saleInfo: SaleInfo? = null,
    val selfLink: String? = null,
    val volumeInfo: VolumeInfo? = null
)
