package ru.kpfu.itis.kmp.core.firebase

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await

actual class AuthService {
    private val auth = Firebase.auth

    actual suspend fun signUpWithEmail(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).await()
    }

    actual suspend fun signInWithEmail(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).await()
    }

    actual fun isUserLoggedIn() = auth.currentUser != null
}
