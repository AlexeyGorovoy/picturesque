package com.github.alexeygorovoy.moxytemplate.ui.common

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity

import com.github.alexeygorovoy.moxytemplate.App
import com.github.alexeygorovoy.moxytemplate.R
import com.github.alexeygorovoy.moxytemplate.dagger.activity.ActivityComponent
import com.github.alexeygorovoy.moxytemplate.dagger.activity.ActivityModule

abstract class BaseActivity : AppCompatActivity() {

    private var activityComponent: ActivityComponent? = null

    fun getActivityComponent(): ActivityComponent {
        return activityComponent ?: createComponent()
            .also { activityComponent = it }
    }

    private fun createComponent() = (application as App).appComponent.plus(ActivityModule())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getActivityComponent().inject(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.shaded_dark_slate_gray)
            window.navigationBarColor = ContextCompat.getColor(this, R.color.shaded_dark_slate_gray)
        }
    }

    fun replaceToFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(BACK_STACK_TAG)
            .commit()
    }

    companion object {

        private const val BACK_STACK_TAG = "back_stack_tag"
    }
}
