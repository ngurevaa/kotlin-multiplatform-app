package ru.kpfu.itis.kmp

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import ru.kpfu.itis.kmp.core.database.databaseModule
import ru.kpfu.itis.kmp.core.database.driverModule
import ru.kpfu.itis.kmp.core.firebase.firebaseModule
import ru.kpfu.itis.kmp.core.network.networkModule
import ru.kpfu.itis.kmp.feature.featureModule
import ru.kpfu.itis.kmp.feature.viewModelModule

fun initKoin(
    appDeclaration: KoinAppDeclaration = {}
) {
    startKoin {
        appDeclaration()

        modules(
            networkModule,
            databaseModule,
            driverModule,
            featureModule,
            firebaseModule
        )
    }
}
