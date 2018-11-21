package com.github.alexeygorovoy.picturesque.dagger.app

import com.github.alexeygorovoy.picturesque.navigation.Router
import com.github.alexeygorovoy.picturesque.utils.rx.AppRxSchedulers
import com.github.alexeygorovoy.picturesque.utils.rx.RxSchedulers

import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    internal fun provideRxSchedulers(): RxSchedulers = AppRxSchedulers()

    @Provides
    internal fun provideRouter(): Router = Router()
}
