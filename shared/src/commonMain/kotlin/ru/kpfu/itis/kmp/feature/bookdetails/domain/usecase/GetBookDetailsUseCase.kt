package ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase

import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book

interface GetBookDetailsUseCase {
    suspend operator fun invoke(id: String): Book
}
