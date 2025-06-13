package ru.kpfu.itis.kmp.feature.home.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.feature.home.data.datasource.PersistenceHomeDatasource
import ru.kpfu.itis.kmp.feature.home.data.datasource.RemoteHomeDatasource
import ru.kpfu.itis.kmp.feature.home.domain.model.Book
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre
import ru.kpfu.itis.kmp.feature.home.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val persistenceGenreDatasource: PersistenceHomeDatasource,
    private val remoteHomeDatasource: RemoteHomeDatasource
) : HomeRepository {
    override suspend fun getGenres(): List<Genre> = persistenceGenreDatasource.getGenres()

    override suspend fun getBooksByGenre(genre: Genre): List<Book> {
        return withContext(Dispatchers.IO) {
            remoteHomeDatasource.getBooksByGenre(genre)
        }
    }
}
