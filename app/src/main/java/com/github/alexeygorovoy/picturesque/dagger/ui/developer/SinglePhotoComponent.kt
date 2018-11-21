package com.github.alexeygorovoy.picturesque.dagger.ui.developer

import com.github.alexeygorovoy.picturesque.ui.developer.singlephoto.view.SinglePhotoFragment
import dagger.Subcomponent

@Subcomponent(modules = [SinglePhotoModule::class])
interface SinglePhotoComponent {

    fun inject(fragment: SinglePhotoFragment)
}
