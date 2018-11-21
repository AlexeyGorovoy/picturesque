package com.github.alexeygorovoy.picturesque.ui.developer.singlephoto.view

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.alexeygorovoy.picturesque.api.data.Photo
import com.github.alexeygorovoy.picturesque.ui.common.moxy.BaseMvpView
import com.github.alexeygorovoy.picturesque.ui.common.moxy.MvpProgressView

interface SinglePhotoView : BaseMvpView, MvpProgressView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showPhotoDetails(photo: Photo)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError(errorMessage: String)

}