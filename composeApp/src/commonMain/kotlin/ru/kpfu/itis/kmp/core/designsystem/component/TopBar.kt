package ru.kpfu.itis.kmp.core.designsystem.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.kpfu.itis.kmp.core.designsystem.icon.IconPack
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.Bookmark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navigateBack: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = IconPack.Bookmark,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    )
}
