package ru.kpfu.itis.kmp.feature.data.usecase

import ru.kpfu.itis.kmp.feature.domain.model.Book
import ru.kpfu.itis.kmp.feature.domain.repository.BookRepository
import ru.kpfu.itis.kmp.feature.domain.usecase.SaveBookUseCase

class SaveBookUseCaseImpl(
    private val bookRepository: BookRepository
) : SaveBookUseCase {
    override suspend operator fun invoke(book: Book) {
        bookRepository.saveBook(book)
    }
}
