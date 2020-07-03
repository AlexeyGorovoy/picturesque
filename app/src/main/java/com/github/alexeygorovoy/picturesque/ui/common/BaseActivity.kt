package com.github.alexeygorovoy.picturesque.ui.common

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.alexeygorovoy.picturesque.R
import com.github.alexeygorovoy.picturesque.navigation.Navigator
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.NavigatorHolder

abstract class BaseActivity : AppCompatActivity() {

    private val navigatorHolder: NavigatorHolder by inject()

    private val navigator: Navigator = Navigator(this, R.id.fragmentContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.shaded_dark_slate_gray)
            window.navigationBarColor = ContextCompat.getColor(this, R.color.shaded_dark_slate_gray)
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}
