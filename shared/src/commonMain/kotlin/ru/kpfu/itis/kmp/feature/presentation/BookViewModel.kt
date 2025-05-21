package ru.kpfu.itis.kmp.feature.presentation

import CommonStateFlow
import androidx.lifecycle.viewModelScope
import asCommonStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel
import ru.kpfu.itis.kmp.feature.domain.model.Book
import ru.kpfu.itis.kmp.feature.domain.usecase.SaveBookUseCase

class BookViewModel : BaseViewModel<BookViewState, BookAction, BookEvent>(
    initState = BookViewState()
), KoinComponent {
    private val saveBookUseCase: SaveBookUseCase by inject()

    override fun obtainEvent(event: BookEvent) {
        when (event) {
            is BookEvent.CreateBook -> createBook(event.name)
        }
    }

    private fun createBook(name: String) {
        viewModelScope.launch {
            runCatching { saveBookUseCase(Book(null, name)) }
                .onSuccess {
                    viewState = viewState.copy(title = name)
                }
                .onFailure {
                    println(it.message)
                }
        }
    }
    fun getViewStates(): CommonStateFlow<BookViewState> = viewStates.asCommonStateFlow()
}
