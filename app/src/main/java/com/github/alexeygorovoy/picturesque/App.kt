package com.github.alexeygorovoy.picturesque

import androidx.multidex.MultiDexApplication

import com.github.alexeygorovoy.picturesque.dagger.app.AppComponent
import com.github.alexeygorovoy.picturesque.dagger.app.AppContextModule
import com.github.alexeygorovoy.picturesque.dagger.app.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary

import timber.log.Timber

class App  : MultiDexApplication() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        initialiseLogger()
        initAppComponent()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(AppContextModule(this)).build()
    }

    private fun initialiseLogger() {
        @Suppress("ConstantConditionIf")
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(object : Timber.Tree() {
                override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                    //TODO  decide what to log in release version
                }
            })
        }
    }
}

