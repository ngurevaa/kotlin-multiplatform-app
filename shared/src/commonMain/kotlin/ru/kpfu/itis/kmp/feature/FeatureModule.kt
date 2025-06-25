package ru.kpfu.itis.kmp.feature

import org.koin.dsl.module
import ru.kpfu.itis.kmp.feature.auth.data.authModule
import ru.kpfu.itis.kmp.feature.bookdetails.data.bookDetailsModule
import ru.kpfu.itis.kmp.feature.bookmarks.data.bookmarksModule
import ru.kpfu.itis.kmp.feature.home.data.homeModule
import ru.kpfu.itis.kmp.feature.search.data.searchModule

val featureModule = module {
    includes(
        viewModelModule,
        authModule,
        homeModule,
        bookDetailsModule,
        bookmarksModule,
        searchModule
    )
}
