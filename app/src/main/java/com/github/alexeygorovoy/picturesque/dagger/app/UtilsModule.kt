package com.github.alexeygorovoy.picturesque.dagger.app

import com.github.alexeygorovoy.picturesque.rx.AppRxSchedulers
import com.github.alexeygorovoy.picturesque.rx.RxSchedulers
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    internal fun provideRxSchedulers(): RxSchedulers = AppRxSchedulers()

}
