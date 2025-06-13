package ru.kpfu.itis.kmp.feature.home.presentation

import CommonStateFlow
import androidx.lifecycle.viewModelScope
import asCommonStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel
import ru.kpfu.itis.kmp.feature.home.domain.usecase.GetBooksUseCase
import ru.kpfu.itis.kmp.feature.home.domain.usecase.GetGenresUseCase

class HomeViewModel : BaseViewModel<HomeViewState, HomeAction, HomeEvent>(
    initState = HomeViewState()
), KoinComponent {
    private val getGenresUseCase: GetGenresUseCase by inject()
    private val getBooksUseCase: GetBooksUseCase by inject()

    init {
        viewModelScope.launch {
            runCatching { getGenresUseCase() }
                .onSuccess { genres ->
                    viewState = viewState.copy(genres = genres)
                }
                .onFailure {
                    // action show error
                }

            runCatching { getBooksUseCase(viewState.genres) }
                .onSuccess {

                }
                .onFailure {
                    println(it.message)
                }
        }
    }

    override fun obtainEvent(event: HomeEvent) {

    }

    fun getViewStates(): CommonStateFlow<HomeViewState> = viewStates.asCommonStateFlow()
}
