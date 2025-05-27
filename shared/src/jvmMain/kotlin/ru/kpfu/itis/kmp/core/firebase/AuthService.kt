package ru.kpfu.itis.kmp.core.firebase

import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual class AuthService : KoinComponent {
    private val httpClient: HttpClient by inject()

    actual suspend fun signUpWithEmail(email: String, password: String) {
        httpClient.post("https://identitytoolkit.googleapis.com/v1/accounts:signUp") {
            url {
                parameter("key", "AIzaSyD7AmcTUSsL93iUuwyFA4XJKbDIIJTya08")
            }
            contentType(ContentType.Application.Json)
            setBody(SignUpRequest(email, password, true))
        }
    }

    actual suspend fun signInWithEmail(email: String, password: String) {

    }
}
