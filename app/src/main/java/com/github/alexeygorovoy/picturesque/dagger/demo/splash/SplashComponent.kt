package com.github.alexeygorovoy.picturesque.dagger.demo.splash

import com.github.alexeygorovoy.picturesque.ui.demo.splash.view.SplashFragment

import dagger.Subcomponent

@Subcomponent(modules = [SplashModule::class])
interface SplashComponent {
    fun inject(fragment: SplashFragment)
}
