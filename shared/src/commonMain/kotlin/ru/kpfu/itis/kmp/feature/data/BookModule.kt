package ru.kpfu.itis.kmp.feature.data

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.kpfu.itis.kmp.feature.data.datasource.PersistentDataSource
import ru.kpfu.itis.kmp.feature.data.datasource.RemoteDataSource
import ru.kpfu.itis.kmp.feature.data.repository.BookRepositoryImpl
import ru.kpfu.itis.kmp.feature.data.usecase.SaveBookUseCaseImpl
import ru.kpfu.itis.kmp.feature.domain.repository.BookRepository
import ru.kpfu.itis.kmp.feature.domain.usecase.SaveBookUseCase

val bookModule = module {
    factoryOf(::PersistentDataSource)
    factoryOf(::RemoteDataSource)

    factory<BookRepository> { BookRepositoryImpl(get()) }
    factory<SaveBookUseCase> { SaveBookUseCaseImpl(get()) }
}
