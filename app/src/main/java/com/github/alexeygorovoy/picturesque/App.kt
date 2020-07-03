package com.github.alexeygorovoy.picturesque

import androidx.multidex.MultiDexApplication
import com.github.alexeygorovoy.picturesque.koin.navigationModule
import com.github.alexeygorovoy.picturesque.koin.networkModule
import com.github.alexeygorovoy.picturesque.koin.singlePhotoModule
import com.github.alexeygorovoy.picturesque.koin.splashModule
import com.github.alexeygorovoy.picturesque.koin.utilsModule
import com.squareup.leakcanary.LeakCanary
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initialiseLogger()
        startKoin()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                navigationModule,
                utilsModule,
                networkModule,
                splashModule,
                singlePhotoModule
            )
        }
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

