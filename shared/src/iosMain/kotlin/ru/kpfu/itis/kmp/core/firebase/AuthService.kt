package ru.kpfu.itis.kmp.core.firebase

import cocoapods.FirebaseAuth.FIRAuth
import cocoapods.FirebaseAuth.FIRUser
import cocoapods.FirebaseAuth.*
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.suspendCancellableCoroutine
import platform.Foundation.NSError
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

@OptIn(ExperimentalForeignApi::class)

actual class AuthService {
    private val auth = FIRAuth.auth()

    actual suspend fun signUpWithEmail(email: String, password: String) {
        suspendCancellableCoroutine<Unit> { continuation ->
            auth?.createUserWithEmail(email, password) { user, error ->
                if (error != null) {
                    continuation.resumeWithException(Exception(error?.localizedDescription ?: "signUpWithEmail error"))
                } else {
                    continuation.resume(Unit)
                }
            }
        }
    }
    actual suspend fun signInWithEmail(email: String, password: String) {
        suspendCancellableCoroutine<Unit> { continuation ->
            auth?.signInWithEmail(email = email, password = password, completion = { authResult: FIRAuthDataResult?, error: NSError? ->
                if (error != null) {
                    continuation.resumeWithException(Exception(error?.localizedDescription ?: "signInWithEmail error"))
                } else {
                    continuation.resume(Unit)
                }
            })
        }
    }

    actual fun isUserLoggedIn(): Boolean {
        return auth?.currentUser != null
    }

    actual fun logout() {
        auth?.signOut(null)
    }
}
