package com.github.alexeygorovoy.picturesque.dagger.app

import android.content.Context
import com.github.alexeygorovoy.picturesque.R
import com.github.alexeygorovoy.picturesque.api.HeroApi
import com.github.alexeygorovoy.picturesque.api.UnsplashApi
import com.github.alexeygorovoy.picturesque.api.interceptors.UnsplashHeadersInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @AppScope
    @Provides
    internal fun provideApiService(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): HeroApi {
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(HEROES_BASE_URL)
            .addConverterFactory(gson)
            .addCallAdapterFactory(rxAdapter)
            .build()

        return retrofit.create(HeroApi::class.java)
    }

    @AppScope
    @Provides
    internal fun provideUnsplashApi(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): UnsplashApi {
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(UNSPLASH_BASE_URL)
            .addConverterFactory(gson)
            .addCallAdapterFactory(rxAdapter)
            .build()

        return retrofit.create(UnsplashApi::class.java)
    }

    @AppScope
    @Provides
    internal fun provideHttpClient(
        logger: HttpLoggingInterceptor,
        unsplashHeadersInterceptor: UnsplashHeadersInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient()
            .newBuilder()
            .addInterceptor(unsplashHeadersInterceptor)
            .addInterceptor(logger)
        return builder.build()
    }

    @AppScope
    @Provides
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @AppScope
    @Provides
    internal fun provideUnsplashHeadersInterceptor(context: Context): UnsplashHeadersInterceptor {
        return UnsplashHeadersInterceptor(context.getString(R.string.unsplash_access_key))
    }

    @AppScope
    @Provides
    internal fun provideRxAdapter(): RxJava2CallAdapterFactory{
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    internal fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    companion object {
        private const val HEROES_BASE_URL = "http://coemygroup.fr/"
        private const val UNSPLASH_BASE_URL = "https://api.unsplash.com/"
    }
}

