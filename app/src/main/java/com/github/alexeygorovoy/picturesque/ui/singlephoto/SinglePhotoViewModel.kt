package com.github.alexeygorovoy.picturesque.ui.singlephoto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.alexeygorovoy.picturesque.api.UnsplashApi
import com.github.alexeygorovoy.picturesque.api.data.Photo
import com.github.alexeygorovoy.picturesque.ui.common.viewModel.BaseViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

class SinglePhotoViewModel(
    private val unsplashApi: UnsplashApi
) : BaseViewModel() {

    private val _singlePhotoResult: MutableLiveData<Result<Photo>> = MutableLiveData()
    val singlePhotoResult: LiveData<Result<Photo>> = _singlePhotoResult

    fun onRefresh() {
        loadRandomPhoto()
    }

    private fun loadRandomPhoto() {
        viewModelScope.launch {
             val photo = withProgress {
                runCatching {
                    unsplashApi.getRandomPhoto()
                }
            }
            _singlePhotoResult.value = photo
            if (photo.isFailure) {
                Timber.e(photo.exceptionOrNull(), "error loading single photo")
            }
        }
    }
}