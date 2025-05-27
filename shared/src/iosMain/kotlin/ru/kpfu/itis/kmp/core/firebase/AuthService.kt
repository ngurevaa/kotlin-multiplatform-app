package ru.kpfu.itis.kmp.core.firebase

//import cocoapods.FirebaseAuth.FIRAuth
//import cocoapods.FirebaseAuth.FIRUser

actual class AuthService {
//    private val auth = FIRAuth.auth()

    actual suspend fun signUpWithEmail(email: String, password: String) {
//        auth?.createUserWithEmail(email, password, null)
    }

    actual suspend fun signInWithEmail(email: String, password: String) {

    }

    actual fun isUserLoggedIn() = false
}
