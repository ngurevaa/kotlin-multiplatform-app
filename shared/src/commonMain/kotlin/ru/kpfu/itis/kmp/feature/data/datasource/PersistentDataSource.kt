package ru.kpfu.itis.kmp.feature.data.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.Database

class PersistentDataSource(
    private val database: Database
) {
    suspend fun insert(name: String) = withContext(Dispatchers.IO) {
        database.bookQueries.insert(id = null, name = name)
    }
}
