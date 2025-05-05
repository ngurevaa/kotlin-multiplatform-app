package ru.kpfu.itis.kmp.core.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.kpfu.itis.kmp.Database

actual val driverModule: Module = module {
    single<SqlDriver> {
        NativeSqliteDriver(Database.Schema, "database.db")
    }
}
