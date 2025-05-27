package ru.kpfu.itis.kmp.feature

import androidx.lifecycle.viewmodel.viewModelFactory
import org.koin.dsl.module
import ru.kpfu.itis.kmp.feature.auth.data.authModule

val featureModule = module {
    includes(
        authModule,
        viewModelModule
    )
}
