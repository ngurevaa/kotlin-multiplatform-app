package ru.kpfu.itis.kmp.feature.bookdetails.data

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.RemoteBookDetailsDatasource
import ru.kpfu.itis.kmp.feature.bookdetails.data.repository.BookDetailsRepositoryImpl
import ru.kpfu.itis.kmp.feature.bookdetails.data.usecase.GetBookDetailsUseCaseImpl
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookDetailsRepository
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.GetBookDetailsUseCase

val bookDetailsModule = module {
    factoryOf(::RemoteBookDetailsDatasource)

    factory<GetBookDetailsUseCase> { GetBookDetailsUseCaseImpl(get()) }
    factory<BookDetailsRepository> { BookDetailsRepositoryImpl(get()) }
}
