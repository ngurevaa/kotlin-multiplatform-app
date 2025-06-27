package ru.kpfu.itis.kmp.core.firebase

import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.analytics.logEvent

actual class AnalyticsService {
    actual suspend fun logFirebaseEvent(event: FirebaseEvent) {
        Firebase.analytics.logEvent(event.name) {
            event.params?.forEach { (key, value) ->
                param(key, value)
            }
        }
    }
}
