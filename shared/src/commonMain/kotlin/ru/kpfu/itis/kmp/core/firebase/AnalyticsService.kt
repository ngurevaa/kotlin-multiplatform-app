package ru.kpfu.itis.kmp.core.firebase

import kotlinx.serialization.Serializable

expect class AnalyticsService() {
    suspend fun logFirebaseEvent(event: FirebaseEvent)
}

@Serializable
data class FirebaseEvent(
    val name: String,
    val params: Map<String, String>? = null,
) {
    companion object {
        const val NAME_OPEN_SCREEN = "open_screen"

        const val PARAM_SCREEN_NAME = "screen_name"
    }
}
