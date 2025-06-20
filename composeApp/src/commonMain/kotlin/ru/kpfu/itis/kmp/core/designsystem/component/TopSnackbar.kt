package ru.kpfu.itis.kmp.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun TopSnackbar(snackbarHostState: SnackbarHostState) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .zIndex(1000f)
    ) {
        SnackbarHost(
            hostState = snackbarHostState
        )
    }
}
