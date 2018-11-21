package com.github.alexeygorovoy.picturesque.dagger.demo.heroes

import com.github.alexeygorovoy.picturesque.api.HeroApi
import com.github.alexeygorovoy.picturesque.ui.demo.heroes.presenter.HeroesListPresenter
import com.github.alexeygorovoy.picturesque.utils.rx.RxSchedulers

import dagger.Module
import dagger.Provides

@Module
class HeroesModule {

    @Provides
    internal fun provideHeroesListPresenter(heroApi: HeroApi, rxSchedulers: RxSchedulers) = HeroesListPresenter(heroApi, rxSchedulers)
}
