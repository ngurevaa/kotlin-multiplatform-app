package ru.kpfu.itis.kmp.feature.bookdetails.data.datasource

import ru.kpfu.itis.kmp.BookmarkDB
import ru.kpfu.itis.kmp.Database

internal class PersistenceBookmarkDatasource(
    private val database: Database
) {
    fun getBookmarkByBookId(bookId: String): BookmarkDB? {
        return database.bookmarkQueries.getByBookId(bookId).executeAsOneOrNull()
    }

    fun save(bookId: String, name: String, author: String, image: String) {
        database.bookmarkQueries.insert(
            id = null,
            book_id = bookId,
            name = name,
            author = author,
            image = image
        )
    }

    fun delete(bookId: String) {
        database.bookmarkQueries.delete(book_id = bookId)
    }
}
