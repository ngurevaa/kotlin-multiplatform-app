package ru.kpfu.itis.kmp.feature.home.data

import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.kpfu.itis.kmp.core.network.WITH_API_KEY_HTTP_CLIENT
import ru.kpfu.itis.kmp.feature.home.data.datasource.PersistenceGenreDatasource
import ru.kpfu.itis.kmp.feature.home.data.datasource.RemoteBookDatasource
import ru.kpfu.itis.kmp.feature.home.data.repository.BookRepositoryImpl
import ru.kpfu.itis.kmp.feature.home.data.repository.GenreRepositoryImpl
import ru.kpfu.itis.kmp.feature.home.data.usecase.GetBooksByGenreUseCaseImpl
import ru.kpfu.itis.kmp.feature.home.data.usecase.GetGenresUseCaseImpl
import ru.kpfu.itis.kmp.feature.home.domain.repository.BookRepository
import ru.kpfu.itis.kmp.feature.home.domain.repository.GenreRepository
import ru.kpfu.itis.kmp.feature.home.domain.usecase.GetBooksByGenreUseCase
import ru.kpfu.itis.kmp.feature.home.domain.usecase.GetGenresUseCase

val homeModule = module {
    factoryOf(::PersistenceGenreDatasource)
    factory { RemoteBookDatasource(get(named(WITH_API_KEY_HTTP_CLIENT))) }

    factory<GenreRepository> { GenreRepositoryImpl(get()) }
    factory<BookRepository> { BookRepositoryImpl(get()) }

    factory<GetGenresUseCase> { GetGenresUseCaseImpl(get()) }
    factory<GetBooksByGenreUseCase> { GetBooksByGenreUseCaseImpl(get()) }
}
