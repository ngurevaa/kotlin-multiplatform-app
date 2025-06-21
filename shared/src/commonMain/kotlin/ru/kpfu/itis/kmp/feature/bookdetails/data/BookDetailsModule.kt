package ru.kpfu.itis.kmp.feature.bookdetails.data

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.PersistenceBookmarkDatasource
import ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.RemoteBookDatasource
import ru.kpfu.itis.kmp.feature.bookdetails.data.repository.BookRepositoryImpl
import ru.kpfu.itis.kmp.feature.bookdetails.data.repository.BookmarkRepositoryImpl
import ru.kpfu.itis.kmp.feature.bookdetails.data.usecase.DeleteBookmarkUseCaseImpl
import ru.kpfu.itis.kmp.feature.bookdetails.data.usecase.GetBookDetailsUseCaseImpl
import ru.kpfu.itis.kmp.feature.bookdetails.data.usecase.SaveBookmarkUseCaseImpl
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookRepository
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookmarkRepository
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.DeleteBookmarkUseCase
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.GetBookDetailsUseCase
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.SaveBookmarkUseCase

val bookDetailsModule = module {
    factoryOf(::RemoteBookDatasource)
    factoryOf(::PersistenceBookmarkDatasource)

    factory<GetBookDetailsUseCase> { GetBookDetailsUseCaseImpl(get(), get()) }
    factory<SaveBookmarkUseCase> { SaveBookmarkUseCaseImpl(get()) }
    factory<DeleteBookmarkUseCase> { DeleteBookmarkUseCaseImpl(get()) }

    factory<BookRepository> { BookRepositoryImpl(get()) }
    factory<BookmarkRepository> { BookmarkRepositoryImpl(get()) }
}
