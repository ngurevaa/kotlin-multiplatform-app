package ru.kpfu.itis.kmp.feature.bookdetails.data.usecase

import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookDetailsRepository
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.GetBookDetailsUseCase

class GetBookDetailsUseCaseImpl(
    private val bookDetailsRepository: BookDetailsRepository
) : GetBookDetailsUseCase {

    override suspend operator fun invoke(id: String): Book {
        return bookDetailsRepository.getBookDetails(id)
    }
}
