package ru.kpfu.itis.kmp.core.firebase

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import ru.kpfu.itis.kmp.core.firebase.remote.SignInResponse
import ru.kpfu.itis.kmp.core.firebase.remote.SignUpRequest
import ru.kpfu.itis.kmp.core.firebase.remote.SignUpResponse
import ru.kpfu.itis.kmp.core.network.WITH_API_KEY_HTTP_CLIENT
import java.util.prefs.Preferences

actual class AuthService : KoinComponent {
    private val httpClient: HttpClient by inject(named(WITH_API_KEY_HTTP_CLIENT))
    private val preferences = Preferences.userRoot().node("/ru/kpfu/itis/book")

    actual suspend fun signUpWithEmail(email: String, password: String) {
        val response = httpClient.post(SIGN_UP_URL) {
            contentType(ContentType.Application.Json)
            setBody(SignUpRequest(email, password, true))
        }
        val token = response.body<SignUpResponse>().idToken
        saveToken(token)
    }

    actual suspend fun signInWithEmail(email: String, password: String) {
        val response = httpClient.post(SIGN_IN_URL) {
            contentType(ContentType.Application.Json)
            setBody(SignUpRequest(email, password, true))
        }
        val token = response.body<SignInResponse>().idToken
        saveToken(token)
    }

    actual fun isUserLoggedIn() = !getToken().isNullOrBlank()

    actual fun logout() {
        preferences.remove(AUTH_TOKEN)
    }

    fun getToken(): String? {
        return preferences.get(AUTH_TOKEN, null)
    }

    fun saveToken(token: String) {
        preferences.put(AUTH_TOKEN, token)
    }

    companion object {
        private const val AUTH_TOKEN = "authToken"
        private const val SIGN_UP_URL = "https://identitytoolkit.googleapis.com/v1/accounts:signUp"
        private const val SIGN_IN_URL = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword"
    }
}
