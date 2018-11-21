package com.github.alexeygorovoy.picturesque.dagger.app

import com.github.alexeygorovoy.picturesque.api.HeroApi

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @AppScope
    @Provides
    internal fun provideApiService(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJavaCallAdapterFactory): HeroApi {
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
    internal fun provideHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient()
            .newBuilder()
            .addInterceptor(logger)
        return builder.build()
    }

    @AppScope
    @Provides
    internal fun provideInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @AppScope
    @Provides
    internal fun provideRxAdapter(): RxJavaCallAdapterFactory {
        return RxJavaCallAdapterFactory.create()
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

