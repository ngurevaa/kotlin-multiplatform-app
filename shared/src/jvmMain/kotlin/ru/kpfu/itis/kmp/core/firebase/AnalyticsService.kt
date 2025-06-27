package ru.kpfu.itis.kmp.core.firebase

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import ru.kpfu.itis.kmp.core.network.WITH_API_KEY_HTTP_CLIENT

actual class AnalyticsService : KoinComponent {
    private val httpClient: HttpClient by inject(named(WITH_API_KEY_HTTP_CLIENT))

    actual suspend fun logFirebaseEvent(event: FirebaseEvent) {
        httpClient.post(FIREBASE_ANALYTICS_URL) {
            contentType(ContentType.Application.Json)
            setBody(event)
        }
    }

    companion object {
        private const val FIREBASE_ANALYTICS_URL = "https://www.google-analytics.com/mp/collect"
    }
}
