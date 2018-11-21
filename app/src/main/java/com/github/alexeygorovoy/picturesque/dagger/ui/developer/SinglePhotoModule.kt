package com.github.alexeygorovoy.picturesque.dagger.ui.developer

import com.github.alexeygorovoy.picturesque.api.UnsplashApi
import com.github.alexeygorovoy.picturesque.ui.developer.singlephoto.presenter.SinglePhotoPresenter
import com.github.alexeygorovoy.picturesque.utils.rx.RxSchedulers
import dagger.Module
import dagger.Provides

@Module
class SinglePhotoModule {

    @Provides
    internal fun provideSinglePhotoPresenter(
        unsplashApi: UnsplashApi,
        rxSchedulers: RxSchedulers
    ) = SinglePhotoPresenter(unsplashApi, rxSchedulers)

}