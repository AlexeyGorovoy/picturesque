package com.github.alexeygorovoy.picturesque.ui.splash.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.alexeygorovoy.picturesque.R
import com.github.alexeygorovoy.picturesque.ui.common.moxy.BaseMvpFragment
import com.github.alexeygorovoy.picturesque.ui.splash.presenter.SplashPresenter
import org.koin.android.ext.android.get

class SplashFragment : BaseMvpFragment(), SplashView {

    @InjectPresenter
    lateinit var splashPresenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter(): SplashPresenter = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }
}
