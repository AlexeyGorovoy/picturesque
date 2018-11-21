package com.github.alexeygorovoy.picturesque.dagger.demo.heroes

import com.github.alexeygorovoy.picturesque.ui.demo.heroes.view.HeroesListFragment

import dagger.Subcomponent

@Subcomponent(modules = [HeroesModule::class])
interface HeroesComponent {

    fun inject(fragment: HeroesListFragment)
}
