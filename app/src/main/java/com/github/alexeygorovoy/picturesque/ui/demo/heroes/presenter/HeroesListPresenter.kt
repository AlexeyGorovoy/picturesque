package com.github.alexeygorovoy.picturesque.ui.demo.heroes.presenter

import com.arellomobile.mvp.InjectViewState
import com.github.alexeygorovoy.picturesque.api.HeroApi
import com.github.alexeygorovoy.picturesque.api.models.Hero
import com.github.alexeygorovoy.picturesque.navigation.Router
import com.github.alexeygorovoy.picturesque.rx.RxSchedulers
import com.github.alexeygorovoy.picturesque.ui.common.moxy.BaseMvpPresenter
import com.github.alexeygorovoy.picturesque.ui.demo.heroes.view.HeroesListView
import timber.log.Timber
import java.util.ArrayList
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class HeroesListPresenter @Inject internal constructor(
    private val heroApi: HeroApi,
    private val rxSchedulers: RxSchedulers,
    private val router: Router
) : BaseMvpPresenter<HeroesListView>() {

    private val heroes = ArrayList<Hero>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadHeroesList()
    }

    private fun loadHeroesList() {
        heroApi.getHeroes()
            .delay(500, TimeUnit.MILLISECONDS)
            .compose(rxSchedulers.ioToMainSingle())
            .progress()
            .subscribe(
                { result ->
                    heroes.clear()
                    heroes.addAll(result.elements)
                    viewState.showHeroes(heroes)
                },
                { throwable -> Timber.e(throwable, "Error loading heroes list!") }
            ).unsubscribeOnDestroy()
    }

    fun onHeroClicked(hero: Hero) {
        router.openHeroDetailsScreen(hero)
    }
}
