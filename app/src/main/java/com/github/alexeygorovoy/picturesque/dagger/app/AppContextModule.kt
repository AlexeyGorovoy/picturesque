package com.github.alexeygorovoy.picturesque.dagger.app

import android.content.Context

import dagger.Module
import dagger.Provides

@Module
class AppContextModule(private val context: Context) {

    @AppScope
    @Provides
    internal fun provideAppContext(): Context {
        return context
    }
}
