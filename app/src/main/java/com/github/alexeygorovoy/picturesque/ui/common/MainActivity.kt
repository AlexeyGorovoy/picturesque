package com.github.alexeygorovoy.picturesque.ui.common

import android.os.Bundle
import com.github.alexeygorovoy.picturesque.R
import com.github.alexeygorovoy.picturesque.navigation.Router
import com.github.alexeygorovoy.picturesque.ui.common.moxy.BaseMvpFragment
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {

    private val router: Router by inject()

    private val currentMvpFragment: BaseMvpFragment?
        get() = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseMvpFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            router.openSplashScreen()
        }
    }

    override fun onBackPressed() {
        val currentMvpFragment = currentMvpFragment
        if (currentMvpFragment?.onBackPressed() == true) {
            return
        }

        super.onBackPressed()
    }
}
