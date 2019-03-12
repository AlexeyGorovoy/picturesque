package com.github.alexeygorovoy.picturesque.ui.common

import android.os.Bundle
import com.github.alexeygorovoy.picturesque.R
import com.github.alexeygorovoy.picturesque.navigation.Router
import com.github.alexeygorovoy.picturesque.ui.common.moxy.BaseMvpFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var router: Router

    private val currentMvpFragment: BaseMvpFragment?
        get() = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseMvpFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getActivityComponent().inject(this)
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
