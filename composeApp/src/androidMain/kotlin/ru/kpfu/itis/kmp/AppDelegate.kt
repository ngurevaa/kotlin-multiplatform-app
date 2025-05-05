package ru.kpfu.itis.kmp

import android.app.Application
import org.koin.android.ext.koin.androidContext

class AppDelegate : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin() {
            androidContext(this@AppDelegate)
        }
    }
}
