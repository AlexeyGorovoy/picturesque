package com.github.alexeygorovoy.picturesque.ui.singlephoto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.alexeygorovoy.picturesque.api.UnsplashApi
import com.github.alexeygorovoy.picturesque.api.data.Photo
import com.github.alexeygorovoy.picturesque.rx.RxSchedulers
import com.github.alexeygorovoy.picturesque.ui.common.viewModel.BaseViewModel
import timber.log.Timber

class SinglePhotoViewModel(
    private val unsplashApi: UnsplashApi,
    private val rxSchedulers: RxSchedulers
) : BaseViewModel() {

    private val _singlePhotoResult: MutableLiveData<Result<Photo>> = MutableLiveData()
    val singlePhotoResult: LiveData<Result<Photo>> = _singlePhotoResult

    fun onRefresh() {
        loadRandomPhoto()
    }

    private fun loadRandomPhoto() {
        unsplashApi.getRandomPhoto()
            .compose(rxSchedulers.ioToMainSingle())
            .progress()
            .subscribe(
                {
                    _singlePhotoResult.value = Result.success(it)
                },
                {
                    _singlePhotoResult.value = Result.failure(it)
                    Timber.e(it, "error loading single photo")
                }
            )
            .unsubscribeOnCleared()
    }
}