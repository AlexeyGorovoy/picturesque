package com.github.alexeygorovoy.picturesque.navigation

import com.github.alexeygorovoy.picturesque.api.models.Hero
import ru.terrakok.cicerone.Router

class Router : Router() {

    fun openSplashScreen() {
        newRootScreen(Screens.SplashScreen())
    }

    fun openHeroListScreen() {
        newRootScreen(Screens.HeroesListScreen())
    }

    fun openHeroDetailsScreen(hero: Hero) {
        navigateTo(Screens.HeroDetailsScreen(hero))
    }

    fun openSinglePhotoScreen() {
        navigateTo(Screens.SinglePhotoScreen())
    }
}
