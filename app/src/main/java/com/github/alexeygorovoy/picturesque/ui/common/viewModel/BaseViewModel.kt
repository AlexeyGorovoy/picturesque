package com.github.alexeygorovoy.picturesque.ui.common.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val disposables = CompositeDisposable()

    protected val _progressLiveData = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> = _progressLiveData

    protected fun <T> Observable<T>.progress(): Observable<T> {
        return doOnSubscribe {
            showProgress()
        }.doAfterTerminate {
            hideProgress()
        }
    }

    protected fun <T> Single<T>.progress(): Single<T> {
        return doOnSubscribe {
            showProgress()
        }.doAfterTerminate {
            hideProgress()
        }
    }

    protected fun Completable.progress(): Completable {
        return doOnSubscribe {
            showProgress()
        }.doAfterTerminate {
            hideProgress()
        }
    }

    protected fun showProgress() {
        _progressLiveData.value = true
    }

    protected fun hideProgress() {
        _progressLiveData.value = false
    }

    protected fun Disposable.unsubscribeOnCleared(): Disposable {
        disposables.add(this)
        return this
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}