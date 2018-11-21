package com.github.alexeygorovoy.picturesque.ui.demo.heroes.presenter

import com.arellomobile.mvp.InjectViewState
import com.github.alexeygorovoy.picturesque.api.HeroApi
import com.github.alexeygorovoy.picturesque.api.models.Hero
import com.github.alexeygorovoy.picturesque.ui.common.moxy.BaseMvpPresenter
import com.github.alexeygorovoy.picturesque.ui.demo.heroes.view.HeroesListView
import com.github.alexeygorovoy.picturesque.utils.rx.RxSchedulers
import timber.log.Timber
import java.util.ArrayList
import java.util.concurrent.TimeUnit

@InjectViewState
class HeroesListPresenter(
    private val heroApi: HeroApi,
    private val rxSchedulers: RxSchedulers
) : BaseMvpPresenter<HeroesListView>() {

    private val heroes = ArrayList<Hero>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadHeroesList()
    }

    private fun loadHeroesList() {
        heroApi.getHeroes()
            .delay(500, TimeUnit.MILLISECONDS)
            .compose(rxSchedulers.ioToMain())
            .compose(progressTransformer())
            .subscribe(
                { result ->
                    heroes.clear()
                    heroes.addAll(result.elements)
                    viewState.showHeroes(heroes)
                },
                { throwable -> Timber.e(throwable, "Error loading heroes list!") }
            ).unsubscribeOnDestroy()
    }
}