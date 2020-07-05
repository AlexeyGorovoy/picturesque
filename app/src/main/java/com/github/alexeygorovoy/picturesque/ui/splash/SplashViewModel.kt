package com.github.alexeygorovoy.picturesque.ui.splash

import com.github.alexeygorovoy.picturesque.navigation.Router
import com.github.alexeygorovoy.picturesque.rx.RxSchedulers
import com.github.alexeygorovoy.picturesque.ui.common.viewModel.BaseViewModel
import io.reactivex.Single
import timber.log.Timber
import java.util.concurrent.TimeUnit

class SplashViewModel(
    private val rxSchedulers: RxSchedulers,
    private val router: Router
) : BaseViewModel() {

    fun waitAndOpenNextScreen() {
        Single.just("")
            .delay(500, TimeUnit.MILLISECONDS)
            .compose(rxSchedulers.computationToMainSingle())
            .subscribe(
                {
                    router.openSinglePhotoScreen()
                },
                { throwable -> Timber.e(throwable, "error on splash!") }
            )
            .unsubscribeOnCleared()
    }
}