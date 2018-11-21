package com.github.alexeygorovoy.picturesque.dagger.demo.details

import com.github.alexeygorovoy.picturesque.ui.demo.details.view.HeroDetailsFragment

import dagger.Subcomponent

@Subcomponent(modules = [HeroDetailsModule::class])
interface HeroDetailsComponent {
    fun inject(fragment: HeroDetailsFragment)
}
