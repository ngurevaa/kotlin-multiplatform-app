package ru.kpfu.itis.kmp.feature

import org.koin.dsl.module
import ru.kpfu.itis.kmp.feature.auth.data.authModule
import ru.kpfu.itis.kmp.feature.home.data.homeModule

val featureModule = module {
    includes(
        viewModelModule,
        authModule,
        homeModule
    )
}
