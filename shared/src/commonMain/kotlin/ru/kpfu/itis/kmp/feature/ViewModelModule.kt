package ru.kpfu.itis.kmp.feature

import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel
import ru.kpfu.itis.kmp.feature.presentation.BookViewModel

val viewModelModule = module {
    viewModel { BookViewModel() }
}
