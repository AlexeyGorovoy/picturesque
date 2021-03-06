package com.github.alexeygorovoy.picturesque.dagger.activity

import com.github.alexeygorovoy.picturesque.dagger.demo.details.HeroDetailsComponent
import com.github.alexeygorovoy.picturesque.dagger.demo.details.HeroDetailsModule
import com.github.alexeygorovoy.picturesque.dagger.demo.heroes.HeroesComponent
import com.github.alexeygorovoy.picturesque.dagger.demo.heroes.HeroesModule
import com.github.alexeygorovoy.picturesque.dagger.demo.splash.SplashComponent
import com.github.alexeygorovoy.picturesque.dagger.demo.splash.SplashModule
import com.github.alexeygorovoy.picturesque.dagger.ui.developer.SinglePhotoComponent
import com.github.alexeygorovoy.picturesque.dagger.ui.developer.SinglePhotoModule
import com.github.alexeygorovoy.picturesque.ui.common.BaseActivity
import com.github.alexeygorovoy.picturesque.ui.common.MainActivity

import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    operator fun plus(module: SplashModule): SplashComponent
    operator fun plus(module: HeroesModule): HeroesComponent
    operator fun plus(module: HeroDetailsModule): HeroDetailsComponent
    operator fun plus(module: SinglePhotoModule): SinglePhotoComponent

    fun inject(baseActivity: BaseActivity)
    fun inject(baseActivity: MainActivity)
}
