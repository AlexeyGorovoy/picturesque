package com.github.alexeygorovoy.picturesque.ui.common

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.alexeygorovoy.picturesque.App
import com.github.alexeygorovoy.picturesque.R
import com.github.alexeygorovoy.picturesque.dagger.activity.ActivityComponent
import com.github.alexeygorovoy.picturesque.dagger.activity.ActivityModule
import com.github.alexeygorovoy.picturesque.navigation.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator = Navigator(this, R.id.fragmentContainer)

    private var activityComponent: ActivityComponent? = null

    fun getActivityComponent(): ActivityComponent {
        return activityComponent ?: createComponent()
            .also { activityComponent = it }
    }

    private fun createComponent() = (application as App).appComponent.plus(ActivityModule(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getActivityComponent().inject(this)

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
