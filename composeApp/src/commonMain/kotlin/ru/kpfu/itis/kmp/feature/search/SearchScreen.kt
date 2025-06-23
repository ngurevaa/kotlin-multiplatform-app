package ru.kpfu.itis.kmp.feature.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import ru.kpfu.itis.kmp.core.designsystem.component.CustomTextField
import ru.kpfu.itis.kmp.core.designsystem.component.TopSnackbar
import ru.kpfu.itis.kmp.core.designsystem.icon.IconPack
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.Search
import ru.kpfu.itis.kmp.core.ui.noRippleClickable
import ru.kpfu.itis.kmp.feature.search.presentation.SearchEvent
import ru.kpfu.itis.kmp.feature.search.presentation.SearchViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = koinViewModel<SearchViewModel>()
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box {
        TopSnackbar(snackbarHostState)
        SearchScreenContent(viewModel)
    }
}

@Composable
internal fun SearchScreenContent(
    viewModel: SearchViewModel
) {
    val state by viewModel.getViewStates().collectAsState()
    val obtainEvent = viewModel::obtainEvent

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Search(
            search = state.search,
            updateSearch = { obtainEvent(SearchEvent.UpdateSearch(it)) },
            searchBook = { obtainEvent(SearchEvent.Search) },
            modifier = Modifier.widthIn(max = 600.dp)
        )
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
                onSearch = { searchBook() }
            ),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            imageVector = IconPack.Search,
            contentDescription = null,
            modifier = Modifier.noRippleClickable { searchBook() }
        )
    }
}
