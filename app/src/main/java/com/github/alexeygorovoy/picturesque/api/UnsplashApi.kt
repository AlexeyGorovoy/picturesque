package com.github.alexeygorovoy.picturesque.api

import com.github.alexeygorovoy.picturesque.api.data.Photo
import retrofit2.http.GET
import rx.Single

interface UnsplashApi {

    @GET("photos/random")
    fun getRandomPhoto() : Single<Photo>
//    @AppScope
//    @Provides
//    internal fun provideUnsplashApi(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJavaCallAdapterFactory) : UnsplashApi {
//        val retrofit = Retrofit.Builder()
//            .client(client)
//            .baseUrl(HEROES_BASE_URL)
//            .addConverterFactory(gson)
//            .addCallAdapterFactory(rxAdapter)
//            .build()
//
//        return retrofit.create(UnsplashApi::class.java)
//    }
}