package ru.kpfu.itis.kmp.core.viewmodel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.swing.Swing
import kotlin.coroutines.CoroutineContext

actual val MainViewModelDispatcher: CoroutineContext = Dispatchers.Swing
