package com.github.alexeygorovoy.picturesque.navigation

import ru.terrakok.cicerone.Router

class Router : Router() {

    fun openSplashScreen() {
        newRootScreen(Screens.SplashScreen())
    }

    fun openSinglePhotoScreen() {
        navigateTo(Screens.SinglePhotoScreen())
    }
}
