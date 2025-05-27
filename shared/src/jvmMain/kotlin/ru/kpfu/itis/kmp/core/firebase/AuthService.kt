package ru.kpfu.itis.kmp.core.firebase

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.firebase.remote.SignInResponse
import ru.kpfu.itis.kmp.core.firebase.remote.SignUpResponse
import java.io.File
import java.util.prefs.Preferences

actual class AuthService : KoinComponent {
    private val httpClient: HttpClient by inject()
    private val preferences = Preferences.userRoot().node("/ru/kpfu/itis/book")

    actual suspend fun signUpWithEmail(email: String, password: String) {
        val response = httpClient.post("https://identitytoolkit.googleapis.com/v1/accounts:signUp") {
            url {
                parameter("key", "AIzaSyD7AmcTUSsL93iUuwyFA4XJKbDIIJTya08")
            }
            contentType(ContentType.Application.Json)
            setBody(SignUpRequest(email, password, true))
        }
        val token = response.body<SignUpResponse>().idToken
        saveToken(token)
    }

    actual suspend fun signInWithEmail(email: String, password: String) {
        val response = httpClient.post("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword") {
            url {
                parameter("key", "AIzaSyD7AmcTUSsL93iUuwyFA4XJKbDIIJTya08")
            }
            contentType(ContentType.Application.Json)
            setBody(SignUpRequest(email, password, true))
        }
        val token = response.body<SignInResponse>().idToken
        println(token)
        saveToken(token)
    }

    actual fun isUserLoggedIn() = !getToken().isNullOrBlank()

    fun getToken(): String? {
        return preferences.get("authToken", null)
    }

    fun saveToken(token: String) {
        preferences.put("authToken", token)
    }
}
