package ru.kpfu.itis.kmp.feature.bookmarks.data

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.kpfu.itis.kmp.feature.bookmarks.data.datasource.PersistenceBookmarkDatasource
import ru.kpfu.itis.kmp.feature.bookmarks.data.repository.BookmarkRepositoryImpl
import ru.kpfu.itis.kmp.feature.bookmarks.data.usecase.GetBookmarksUseCaseImpl
import ru.kpfu.itis.kmp.feature.bookmarks.domain.repository.BookmarkRepository
import ru.kpfu.itis.kmp.feature.bookmarks.domain.usecase.GetBookmarksUseCase

val bookmarksModule = module {
    factoryOf(::PersistenceBookmarkDatasource)

    factory<BookmarkRepository> { BookmarkRepositoryImpl(get()) }
    factory<GetBookmarksUseCase> { GetBookmarksUseCaseImpl(get()) }
}
