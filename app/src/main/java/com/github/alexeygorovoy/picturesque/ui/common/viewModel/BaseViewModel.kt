package com.github.alexeygorovoy.picturesque.ui.common.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    protected val _progressLiveData = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> = _progressLiveData

    protected fun showProgress() {
        _progressLiveData.value = true
    }

    protected fun hideProgress() {
        _progressLiveData.value = false
    }

    protected inline fun <R> withProgress(block: ()-> R): R {
        showProgress()
        return block().also {
            hideProgress()
        }
    }
}