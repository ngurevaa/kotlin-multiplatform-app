package ru.kpfu.itis.kmp.core.firebase

import org.koin.dsl.module

val firebaseModule = module {
    single { AuthService() }
    single { AnalyticsService() }
}
