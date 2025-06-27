package ru.kpfu.itis.kmp.feature.auth.data

import org.koin.dsl.module
import ru.kpfu.itis.kmp.feature.auth.data.repository.FirebaseRepositoryImpl
import ru.kpfu.itis.kmp.feature.auth.data.usecase.SendFirebaseEventUseCaseImpl
import ru.kpfu.itis.kmp.feature.auth.data.usecase.SignInUseCaseImpl
import ru.kpfu.itis.kmp.feature.auth.data.usecase.SignUpUseCaseImpl
import ru.kpfu.itis.kmp.feature.auth.domain.repository.FirebaseRepository
import ru.kpfu.itis.kmp.feature.auth.domain.usecase.SendFirebaseEventUseCase
import ru.kpfu.itis.kmp.feature.auth.domain.usecase.SignInUseCase
import ru.kpfu.itis.kmp.feature.auth.domain.usecase.SignUpUseCase

val authModule = module {
    factory<SignUpUseCase> { SignUpUseCaseImpl(get()) }
    factory<SignInUseCase> { SignInUseCaseImpl(get()) }
    factory<SendFirebaseEventUseCase> { SendFirebaseEventUseCaseImpl(get()) }

    factory<FirebaseRepository> { FirebaseRepositoryImpl(get(), get()) }
}
