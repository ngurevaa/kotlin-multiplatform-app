package ru.kpfu.itis.kmp.feature.home.data.datasource

import ru.kpfu.itis.kmp.Database
import ru.kpfu.itis.kmp.GenreDB

internal class PersistenceGenreDatasource(
    private val database: Database
) {
    fun getAll(): List<GenreDB> = database.genreQueries.getAll().executeAsList()
}
