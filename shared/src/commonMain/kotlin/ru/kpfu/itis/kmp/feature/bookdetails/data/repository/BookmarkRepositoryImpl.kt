package ru.kpfu.itis.kmp.feature.bookdetails.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.PersistenceBookmarkDatasource
import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookmarkRepository

internal class BookmarkRepositoryImpl(
    private val persistenceBookDetailsDatasource: PersistenceBookmarkDatasource
) : BookmarkRepository {

    override suspend fun isBookmark(bookId: String): Boolean {
        return withContext(Dispatchers.IO) {
            val bookmark = persistenceBookDetailsDatasource.getBookmarkByBookId(bookId)
            bookmark != null
        }
    }

    override suspend fun saveBookmark(book: Book) {
        withContext(Dispatchers.IO) {
            persistenceBookDetailsDatasource.save(book.id, book.name, book.author, book.image)
        }
    }

    override suspend fun deleteBookmark(bookId: String) {
        withContext(Dispatchers.IO) {
            persistenceBookDetailsDatasource.delete(bookId)
        }
    }
}
