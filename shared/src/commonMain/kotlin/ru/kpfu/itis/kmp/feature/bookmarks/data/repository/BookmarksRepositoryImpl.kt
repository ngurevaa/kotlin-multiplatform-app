package ru.kpfu.itis.kmp.feature.bookmarks.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.feature.bookmarks.data.datasource.PersistenceBookmarkDatasource
import ru.kpfu.itis.kmp.feature.bookmarks.data.mapper.mapToBookList
import ru.kpfu.itis.kmp.feature.bookmarks.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookmarks.domain.repository.BookmarksRepository

class BookmarksRepositoryImpl(
    private val persistenceBookmarksDatasource: PersistenceBookmarkDatasource
) : BookmarksRepository {
    override suspend fun getBookmarks(): List<Book> {
        return withContext(Dispatchers.IO) {
            persistenceBookmarksDatasource.getAll().mapToBookList()
        }
    }
}
