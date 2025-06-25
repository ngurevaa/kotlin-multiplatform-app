package ru.kpfu.itis.kmp.feature.search.data

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.kpfu.itis.kmp.feature.search.data.datasource.RemoteBookDatasource
import ru.kpfu.itis.kmp.feature.search.data.repository.BookRepositoryImpl
import ru.kpfu.itis.kmp.feature.search.data.usecase.SearchBooksByAuthorUseCaseImpl
import ru.kpfu.itis.kmp.feature.search.data.usecase.SearchBooksByGenreUseCaseImpl
import ru.kpfu.itis.kmp.feature.search.data.usecase.SearchBooksByTitleUseCaseImpl
import ru.kpfu.itis.kmp.feature.search.domain.repository.BookRepository
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SearchBooksByAuthorUseCase
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SearchBooksByGenreUseCase
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SearchBooksByTitleUseCase

val searchModule = module {
    factoryOf(::RemoteBookDatasource)

    factory<SearchBooksByTitleUseCase> { SearchBooksByTitleUseCaseImpl(get()) }
    factory<SearchBooksByAuthorUseCase> { SearchBooksByAuthorUseCaseImpl(get()) }
    factory<SearchBooksByGenreUseCase> { SearchBooksByGenreUseCaseImpl(get()) }

    factory<BookRepository> { BookRepositoryImpl(get()) }
}
