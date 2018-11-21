package com.github.alexeygorovoy.picturesque.dagger.demo.splash

import com.github.alexeygorovoy.picturesque.ui.demo.splash.presenter.SplashPresenter
import com.github.alexeygorovoy.picturesque.utils.rx.RxSchedulers

import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    internal fun provideSplashPresenter(schedulers: RxSchedulers) = SplashPresenter(schedulers)
}

