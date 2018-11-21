package com.github.alexeygorovoy.picturesque.ui.demo.heroes.view

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.alexeygorovoy.picturesque.api.models.Hero
import com.github.alexeygorovoy.picturesque.ui.common.moxy.BaseMvpView
import com.github.alexeygorovoy.picturesque.ui.common.moxy.MvpProgressView

interface HeroesListView : BaseMvpView, MvpProgressView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showHeroes(heroes: List<Hero>)
}
