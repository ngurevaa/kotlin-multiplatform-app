package ru.kpfu.itis.kmp.feature.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import exampleapp.composeapp.generated.resources.Res
import exampleapp.composeapp.generated.resources.empty_search_query_error
import exampleapp.composeapp.generated.resources.internet_connection_error
import exampleapp.composeapp.generated.resources.search_by
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ru.kpfu.itis.kmp.core.designsystem.component.BookCard
import ru.kpfu.itis.kmp.core.designsystem.component.CustomTextField
import ru.kpfu.itis.kmp.core.designsystem.component.TopSnackbar
import ru.kpfu.itis.kmp.core.designsystem.icon.IconPack
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.Search
import ru.kpfu.itis.kmp.core.ui.noRippleClickable
import ru.kpfu.itis.kmp.core.ui.showSnackbar
import ru.kpfu.itis.kmp.feature.search.domain.model.Book
import ru.kpfu.itis.kmp.feature.search.presentation.Filter
import ru.kpfu.itis.kmp.feature.search.presentation.SearchAction
import ru.kpfu.itis.kmp.feature.search.presentation.SearchEvent
import ru.kpfu.itis.kmp.feature.search.presentation.SearchViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = koinViewModel<SearchViewModel>(),
    navigateToBook: (String) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.statusBarsPadding()
    ) {
        TopSnackbar(snackbarHostState)
        SearchScreenContent(viewModel)
    }

    val internetConnectionError = stringResource(Res.string.internet_connection_error)
    val emptySearchQueryError = stringResource(Res.string.empty_search_query_error)
    LaunchedEffect(Unit) {
        viewModel.obtainEvent(SearchEvent.OpenScreen)

        viewModel.getActions().collectLatest { action ->
            when(action) {
                is SearchAction.NavigateToBook -> navigateToBook(action.id)
                is SearchAction.ShowEmptySearchError -> {
                    showSnackbar(snackbarHostState, coroutineScope, emptySearchQueryError)
                }
                is SearchAction.ShowInternetConnectionError -> {
                    showSnackbar(snackbarHostState, coroutineScope, internetConnectionError)
                }
            }
        }
    }
}

@Composable
internal fun SearchScreenContent(
    viewModel: SearchViewModel
) {
    val state by viewModel.getViewStates().collectAsState()
    val obtainEvent = viewModel::obtainEvent

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Filter(
            filters = state.filters,
            selected = state.selectedFilter,
            selectFilter = { obtainEvent(SearchEvent.SelectFilter(it)) },
            modifier = Modifier.widthIn(max = 600.dp).padding(24.dp)
        )
        Search(
            search = state.search,
            updateSearch = { obtainEvent(SearchEvent.UpdateSearch(it)) },
            searchBook = { obtainEvent(SearchEvent.Search) },
            modifier = Modifier.widthIn(max = 600.dp).padding(horizontal = 24.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        if (state.isLoading) {
            CircularProgressIndicator()
        }
        else {
            SearchBooks(
                books = state.books,
                clickToBook = { obtainEvent(SearchEvent.ClickToBook(it)) }
            )
        }
    }
}

@Composable
internal fun Search(
    search: String,
    updateSearch: (String) -> Unit,
    searchBook: () -> Unit,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomTextField(
            value = search,
            onValueChange = { updateSearch(it) },
            modifier = Modifier.focusRequester(focusRequester).weight(0.8f),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardController?.hide()
                    searchBook()
                }
            ),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            imageVector = IconPack.Search,
            contentDescription = null,
            modifier = Modifier.noRippleClickable {
                keyboardController?.hide()
                searchBook()
            }
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun Filter(
    filters: List<Filter>,
    selected: Filter,
    selectFilter: (Filter) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(Res.string.search_by),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth()
        )

        Row(Modifier.selectableGroup()) {
            filters.forEach { filter ->
                Row(
                    modifier = Modifier
                        .height(36.dp)
                        .selectable(
                            selected = (filter == selected),
                            onClick = { selectFilter(filter) },
                            role = Role.RadioButton
                        )
                        .padding(end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (filter == selected),
                        onClick = null
                    )
                    Text(
                        text = filter.name,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
internal fun SearchBooks(
    books: List<Book>,
    clickToBook: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 160.dp)
    ) {

        items(books) { book ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                BookCard(
                    name = book.name,
                    author = book.author,
                    image = book.image,
                    modifier = Modifier.noRippleClickable {
                        clickToBook(book.id)
                    }
                )
            }
        }
    }
}
