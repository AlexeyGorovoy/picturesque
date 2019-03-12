package com.github.alexeygorovoy.picturesque.navigation

import androidx.fragment.app.Fragment
import com.github.alexeygorovoy.picturesque.api.models.Hero
import com.github.alexeygorovoy.picturesque.ui.demo.details.view.HeroDetailsFragment
import com.github.alexeygorovoy.picturesque.ui.demo.heroes.view.HeroesListFragment
import com.github.alexeygorovoy.picturesque.ui.demo.splash.view.SplashFragment
import com.github.alexeygorovoy.picturesque.ui.developer.singlephoto.view.SinglePhotoFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class HeroDetailsScreen(private val hero: Hero) : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return HeroDetailsFragment.newInstance(hero)
        }
    }

    class HeroesListScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return HeroesListFragment.newInstance()
        }
    }

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