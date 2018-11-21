package com.github.alexeygorovoy.picturesque.dagger.demo.details

import com.github.alexeygorovoy.picturesque.ui.demo.details.presenter.HeroDetailsPresenter

import dagger.Module
import dagger.Provides

@Module
class HeroDetailsModule {

    @Provides
    internal fun heroDetailsPresenter(): HeroDetailsPresenter = HeroDetailsPresenter()
}
