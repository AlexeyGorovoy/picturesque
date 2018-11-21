package com.github.alexeygorovoy.picturesque.ui.demo.details.presenter

import com.arellomobile.mvp.InjectViewState
import com.github.alexeygorovoy.picturesque.api.models.Hero
import com.github.alexeygorovoy.picturesque.ui.common.moxy.BaseMvpPresenter
import com.github.alexeygorovoy.picturesque.ui.demo.details.view.HeroDetailsView

@InjectViewState
class HeroDetailsPresenter : BaseMvpPresenter<HeroDetailsView>() {

    private lateinit var hero: Hero

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showHero(hero)
    }

    fun setHero(hero: Hero) {
        this.hero = hero
    }
}
