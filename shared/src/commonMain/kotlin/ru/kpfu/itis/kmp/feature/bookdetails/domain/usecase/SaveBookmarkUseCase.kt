package ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase

import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book

interface SaveBookmarkUseCase {
    suspend operator fun invoke(book: Book)
}
