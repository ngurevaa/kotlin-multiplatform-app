package ru.kpfu.itis.kmp.feature.bookdetails.data

import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.kpfu.itis.kmp.core.network.WITHOUT_API_KEY_HTTP_CLIENT
import ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.PersistenceBookmarkDatasource
import ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.RemoteBookDatasource
import ru.kpfu.itis.kmp.feature.bookdetails.data.repository.BookRepositoryImpl
import ru.kpfu.itis.kmp.feature.bookdetails.data.repository.BookmarkRepositoryImpl
import ru.kpfu.itis.kmp.feature.bookdetails.data.repository.FirebaseRepositoryImpl
import ru.kpfu.itis.kmp.feature.bookdetails.data.usecase.DeleteBookmarkUseCaseImpl
import ru.kpfu.itis.kmp.feature.bookdetails.data.usecase.GetBookDetailsUseCaseImpl
import ru.kpfu.itis.kmp.feature.bookdetails.data.usecase.SaveBookmarkUseCaseImpl
import ru.kpfu.itis.kmp.feature.bookdetails.data.usecase.SendFirebaseEventUseCaseImpl
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookRepository
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookmarkRepository
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.FirebaseRepository
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.DeleteBookmarkUseCase
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.GetBookDetailsUseCase
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.SaveBookmarkUseCase
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.SendFirebaseEventUseCase

val bookDetailsModule = module {
    factory { RemoteBookDatasource(get(named(WITHOUT_API_KEY_HTTP_CLIENT))) }
    factoryOf(::PersistenceBookmarkDatasource)

    factory<GetBookDetailsUseCase> { GetBookDetailsUseCaseImpl(get(), get()) }
    factory<SaveBookmarkUseCase> { SaveBookmarkUseCaseImpl(get()) }
    factory<DeleteBookmarkUseCase> { DeleteBookmarkUseCaseImpl(get()) }
    factory<SendFirebaseEventUseCase> { SendFirebaseEventUseCaseImpl(get()) }

    factory<BookRepository> { BookRepositoryImpl(get()) }
    factory<BookmarkRepository> { BookmarkRepositoryImpl(get()) }
    factory<FirebaseRepository> { FirebaseRepositoryImpl(get()) }
}
