package ru.kpfu.itis.kmp.core.viewmodel

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual val MainViewModelDispatcher: CoroutineContext = Dispatchers.Main
