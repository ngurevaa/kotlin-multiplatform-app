package ru.kpfu.itis.kmp.feature.search.data

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.kpfu.itis.kmp.core.network.WITH_API_KEY_HTTP_CLIENT
import ru.kpfu.itis.kmp.feature.search.data.datasource.RemoteBookDatasource
import ru.kpfu.itis.kmp.feature.search.data.repository.BookRepositoryImpl
import ru.kpfu.itis.kmp.feature.search.data.repository.FirebaseRepositoryImpl
import ru.kpfu.itis.kmp.feature.search.data.usecase.SearchBooksByAuthorUseCaseImpl
import ru.kpfu.itis.kmp.feature.search.data.usecase.SearchBooksByGenreUseCaseImpl
import ru.kpfu.itis.kmp.feature.search.data.usecase.SearchBooksByTitleUseCaseImpl
import ru.kpfu.itis.kmp.feature.search.data.usecase.SendFirebaseEventUseCaseImpl
import ru.kpfu.itis.kmp.feature.search.domain.repository.BookRepository
import ru.kpfu.itis.kmp.feature.search.domain.repository.FirebaseRepository
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SearchBooksByAuthorUseCase
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SearchBooksByGenreUseCase
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SearchBooksByTitleUseCase
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SendFirebaseEventUseCase

val searchModule = module {
    factory { RemoteBookDatasource(get(named(WITH_API_KEY_HTTP_CLIENT))) }

    factory<SearchBooksByTitleUseCase> { SearchBooksByTitleUseCaseImpl(get()) }
    factory<SearchBooksByAuthorUseCase> { SearchBooksByAuthorUseCaseImpl(get()) }
    factory<SearchBooksByGenreUseCase> { SearchBooksByGenreUseCaseImpl(get()) }
    factory<SendFirebaseEventUseCase> { SendFirebaseEventUseCaseImpl(get()) }

    factory<BookRepository> { BookRepositoryImpl(get()) }
    factory<FirebaseRepository> { FirebaseRepositoryImpl(get()) }
}
