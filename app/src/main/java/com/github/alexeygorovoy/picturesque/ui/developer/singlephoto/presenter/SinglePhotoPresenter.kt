package com.github.alexeygorovoy.picturesque.ui.developer.singlephoto.presenter

import com.arellomobile.mvp.InjectViewState
import com.github.alexeygorovoy.picturesque.api.UnsplashApi
import com.github.alexeygorovoy.picturesque.rx.RxSchedulers
import com.github.alexeygorovoy.picturesque.ui.common.moxy.BaseMvpPresenter
import com.github.alexeygorovoy.picturesque.ui.developer.singlephoto.view.SinglePhotoView
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class SinglePhotoPresenter internal constructor(
    private val unsplashApi: UnsplashApi,
    private val rxSchedulers: RxSchedulers
) : BaseMvpPresenter<SinglePhotoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadRandomPhoto()
    }

    fun onRefresh() {
        loadRandomPhoto()
    }

    private fun loadRandomPhoto() {
        unsplashApi.getRandomPhoto()
            .compose(rxSchedulers.ioToMainSingle())
            .progress()
            .subscribe(
                {
                    viewState.showPhotoDetails(it)
                },
                {
                    viewState.showError(it.message ?: "Error occurred, see logs")
                    Timber.e(it, "error loading single photo")
                }
            )
            .unsubscribeOnDestroy()
    }
}