package com.github.alexeygorovoy.picturesque.ui.demo.splash

import android.os.Bundle

import com.github.alexeygorovoy.picturesque.R
import com.github.alexeygorovoy.picturesque.ui.common.BaseActivity

class SplashActivity : BaseActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
    }
}
