package ru.kpfu.itis.kmp.feature.home.data.usecase

import ru.kpfu.itis.kmp.core.firebase.AuthService
import ru.kpfu.itis.kmp.feature.home.domain.repository.FirebaseRepository

class FirebaseRepositoryImpl(
    private val authService: AuthService
) : FirebaseRepository {
    override fun logout() {
        authService.logout()
    }
}
