package ru.kpfu.itis.kmp.feature.auth.domain.usecase

interface SignUpUseCase {
    suspend operator fun invoke(email: String, password: String)
}
