package ru.kpfu.itis.kmp.feature.domain.usecase

import ru.kpfu.itis.kmp.feature.domain.model.Book

interface SaveBookUseCase {
    suspend operator fun invoke(book: Book)
}
