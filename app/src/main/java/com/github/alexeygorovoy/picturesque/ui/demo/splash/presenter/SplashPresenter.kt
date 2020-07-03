package com.github.alexeygorovoy.picturesque.ui.demo.splash.presenter

import com.arellomobile.mvp.InjectViewState
import com.github.alexeygorovoy.picturesque.navigation.Router
import com.github.alexeygorovoy.picturesque.rx.RxSchedulers
import com.github.alexeygorovoy.picturesque.ui.common.moxy.BaseMvpPresenter
import com.github.alexeygorovoy.picturesque.ui.demo.splash.view.SplashView
import io.reactivex.Single
import timber.log.Timber
import java.util.concurrent.TimeUnit

@InjectViewState
class SplashPresenter internal constructor(
    private val rxSchedulers: RxSchedulers,
    private val router: Router
) : BaseMvpPresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        // real loading will happen here if needed
        Single.just("")
            .delay(500, TimeUnit.MILLISECONDS)
            .compose(rxSchedulers.computationToMainSingle())
            .subscribe(
                {
                    router.openSinglePhotoScreen()
                },
                { throwable -> Timber.e(throwable, "error on splash!") }
            )
            .unsubscribeOnDestroy()
    }
}
