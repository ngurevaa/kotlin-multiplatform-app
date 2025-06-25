package ru.kpfu.itis.kmp.feature.bookmarks.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.feature.bookmarks.data.datasource.PersistenceBookmarkDatasource
import ru.kpfu.itis.kmp.feature.bookmarks.data.mapper.mapToBookList
import ru.kpfu.itis.kmp.feature.bookmarks.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookmarks.domain.repository.BookmarkRepository

class BookmarkRepositoryImpl(
    private val persistenceBookmarksDatasource: PersistenceBookmarkDatasource
) : BookmarkRepository {
    override suspend fun getBookmarks(): List<Book> {
        return withContext(Dispatchers.IO) {
            persistenceBookmarksDatasource.getAll().mapToBookList()
        }
    }
}
