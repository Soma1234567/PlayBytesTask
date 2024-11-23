package com.soma.playbytestask

import android.app.Application
import com.soma.playbytestask.di.appmodule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp:Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(appmodule)
        }
    }
}