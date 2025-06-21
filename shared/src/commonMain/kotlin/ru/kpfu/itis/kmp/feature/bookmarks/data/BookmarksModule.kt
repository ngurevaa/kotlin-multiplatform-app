package ru.kpfu.itis.kmp.feature.bookmarks.data

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.kpfu.itis.kmp.feature.bookmarks.data.datasource.PersistenceBookmarkDatasource
import ru.kpfu.itis.kmp.feature.bookmarks.data.repository.BookmarksRepositoryImpl
import ru.kpfu.itis.kmp.feature.bookmarks.data.usecase.GetBookmarksUseCaseImpl
import ru.kpfu.itis.kmp.feature.bookmarks.domain.repository.BookmarksRepository
import ru.kpfu.itis.kmp.feature.bookmarks.domain.usecase.GetBookmarksUseCase

val bookmarksModule = module {
    factoryOf(::PersistenceBookmarkDatasource)

    factory<BookmarksRepository> { BookmarksRepositoryImpl(get()) }
    factory<GetBookmarksUseCase> { GetBookmarksUseCaseImpl(get()) }
}
