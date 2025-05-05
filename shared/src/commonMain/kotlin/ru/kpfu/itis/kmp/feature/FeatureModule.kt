package ru.kpfu.itis.kmp.feature

import androidx.lifecycle.viewmodel.viewModelFactory
import org.koin.dsl.module
import ru.kpfu.itis.kmp.feature.data.bookModule

val featureModule = module {
    includes(
        bookModule,
        viewModelModule
    )
}
