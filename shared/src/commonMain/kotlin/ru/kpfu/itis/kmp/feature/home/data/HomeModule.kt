package ru.kpfu.itis.kmp.feature.home.data

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.kpfu.itis.kmp.feature.home.data.datasource.PersistenceHomeDatasource
import ru.kpfu.itis.kmp.feature.home.data.datasource.RemoteHomeDatasource
import ru.kpfu.itis.kmp.feature.home.data.repository.HomeRepositoryImpl
import ru.kpfu.itis.kmp.feature.home.data.usecase.GetBooksByGenreUseCaseImpl
import ru.kpfu.itis.kmp.feature.home.data.usecase.GetGenresUseCaseImpl
import ru.kpfu.itis.kmp.feature.home.domain.repository.HomeRepository
import ru.kpfu.itis.kmp.feature.home.domain.usecase.GetBooksByGenreUseCase
import ru.kpfu.itis.kmp.feature.home.domain.usecase.GetGenresUseCase

val homeModule = module {
    factoryOf(::PersistenceHomeDatasource)
    factoryOf(::RemoteHomeDatasource)

    factory<HomeRepository> { HomeRepositoryImpl(get(), get()) }
    factory<GetGenresUseCase> { GetGenresUseCaseImpl(get()) }
    factory<GetBooksByGenreUseCase> { GetBooksByGenreUseCaseImpl(get()) }
}
