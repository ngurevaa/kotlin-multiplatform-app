package ru.kpfu.itis.kmp.feature.home.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.feature.home.data.datasource.PersistenceGenreDatasource
import ru.kpfu.itis.kmp.feature.home.data.mapper.mapToGenreList
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre
import ru.kpfu.itis.kmp.feature.home.domain.repository.GenreRepository

internal class GenreRepositoryImpl(
    private val persistenceGenreDatasource: PersistenceGenreDatasource
) : GenreRepository {
    override suspend fun getGenres(): List<Genre> {
        return persistenceGenreDatasource.getAll().mapToGenreList()
    }
}
