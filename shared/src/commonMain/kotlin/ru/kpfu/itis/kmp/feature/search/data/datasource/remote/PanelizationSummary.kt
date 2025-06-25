package ru.kpfu.itis.kmp.feature.search.data.datasource.remote

import kotlinx.serialization.Serializable

@Serializable
data class PanelizationSummary(
    val containsEpubBubbles: Boolean? = null,
    val containsImageBubbles: Boolean? = null
)
