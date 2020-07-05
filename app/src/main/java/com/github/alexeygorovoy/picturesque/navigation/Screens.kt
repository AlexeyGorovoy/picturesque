package com.github.alexeygorovoy.picturesque.navigation

import androidx.fragment.app.Fragment
import com.github.alexeygorovoy.picturesque.ui.splash.SplashFragment
import com.github.alexeygorovoy.picturesque.ui.singlephoto.view.SinglePhotoFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class SplashScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return SplashFragment()
        }
    }

    class SinglePhotoScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return SinglePhotoFragment.newInstance()
        }
    }
}