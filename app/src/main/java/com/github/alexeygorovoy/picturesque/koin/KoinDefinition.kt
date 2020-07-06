package com.github.alexeygorovoy.picturesque.koin

import android.content.Context
import com.github.alexeygorovoy.picturesque.R
import com.github.alexeygorovoy.picturesque.api.UnsplashApi
import com.github.alexeygorovoy.picturesque.api.interceptors.UnsplashHeadersInterceptor
import com.github.alexeygorovoy.picturesque.navigation.Router
import com.github.alexeygorovoy.picturesque.ui.singlephoto.SinglePhotoViewModel
import com.github.alexeygorovoy.picturesque.ui.splash.SplashViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.terrakok.cicerone.Cicerone

val navigationModule = module {
    single {
        Router()
    }
    single<Cicerone<Router>> {
        Cicerone.create(get())
    }
    single {
        get<Cicerone<Router>>().navigatorHolder
    }
}

val utilsModule = module {

}

const val UNSPLASH_BASE_URL = "https://api.unsplash.com/"

val networkModule = module {

    single {
        val httpClient = get<OkHttpClient>()
        val converterFactory = get<GsonConverterFactory>()

        val retrofit = Retrofit.Builder()
            .client(httpClient)
            .baseUrl(UNSPLASH_BASE_URL)
            .addConverterFactory(converterFactory)
            .build()

        retrofit.create(UnsplashApi::class.java)
    }

    single {
        val logger = get<HttpLoggingInterceptor>()
        val unsplashHeadersInterceptor = get<UnsplashHeadersInterceptor>()
        OkHttpClient()
            .newBuilder()
            .addInterceptor(unsplashHeadersInterceptor)
            .addInterceptor(logger)
            .build()
    }

    single {
        val context = get<Context>()
        UnsplashHeadersInterceptor(context.getString(R.string.unsplash_access_key))
    }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        GsonConverterFactory.create()
    }
}

val splashModule = module {
    viewModel {
        SplashViewModel(get())
    }
}

val singlePhotoModule = module {
    viewModel {
        SinglePhotoViewModel(get())
    }
}