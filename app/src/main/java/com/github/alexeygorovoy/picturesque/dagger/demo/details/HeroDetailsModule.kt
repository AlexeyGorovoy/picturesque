package com.github.alexeygorovoy.picturesque.dagger.demo.details

import com.github.alexeygorovoy.picturesque.api.models.Hero
import dagger.Module
import dagger.Provides

@Module
class HeroDetailsModule(private val hero: Hero) {

    @Provides
    internal fun provideHero(): Hero = hero
}