package ru.kpfu.itis.kmp.core.database

import org.koin.dsl.module
import ru.kpfu.itis.kmp.Database

val databaseModule = module {
    single<Database> {
        Database(driver = get())
    }
}
