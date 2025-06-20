package ru.kpfu.itis.kmp.core.designsystem.icon

import androidx.compose.ui.graphics.vector.ImageVector
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.Bookmark
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.BookmarkFill
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.DarkMode
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.Home
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.HomeFill
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.LightMode
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.Search
import kotlin.collections.List as ____KtList

public object IconPack

private var __AllIcons: ____KtList<ImageVector>? = null

public val IconPack.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Home, HomeFill, Bookmark, BookmarkFill, Search, DarkMode, LightMode)
    return __AllIcons!!
  }
