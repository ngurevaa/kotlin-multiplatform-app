package ru.kpfu.itis.kmp.feature.search.presentation

import CommonFlow
import CommonStateFlow
import androidx.lifecycle.viewModelScope
import asCommonFlow
import asCommonStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel

class SearchViewModel : BaseViewModel<SearchViewState, SearchAction, SearchEvent>(
    initState = SearchViewState()
), KoinComponent {

    override fun obtainEvent(event: SearchEvent) {
        when(event) {
            is SearchEvent.UpdateSearch -> updateSearch(event.search)
            is SearchEvent.Search -> search()
        }
    }

    private fun search() {
        viewModelScope.launch {
            runCatching {  }
        }
    }

    private fun updateSearch(search: String) {
        viewState = viewState.copy(search = search)
    }

    fun getViewStates(): CommonStateFlow<SearchViewState> = viewStates.asCommonStateFlow()
    fun getActions(): CommonFlow<SearchAction> = actions.asCommonFlow()
}
