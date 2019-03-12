package com.github.alexeygorovoy.picturesque.dagger.app

import com.github.alexeygorovoy.picturesque.api.HeroApi
import com.github.alexeygorovoy.picturesque.dagger.activity.ActivityComponent
import com.github.alexeygorovoy.picturesque.dagger.activity.ActivityModule
import com.github.alexeygorovoy.picturesque.rx.RxSchedulers
import dagger.Component

@AppScope
@Component(modules = [NetworkModule::class, NavigationModule::class, AppContextModule::class, UtilsModule::class])
interface AppComponent {

    operator fun plus(activityModule: ActivityModule): ActivityComponent

    fun rxSchedulers(): RxSchedulers

    fun apiService(): HeroApi
}
