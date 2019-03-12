package com.github.alexeygorovoy.picturesque.api

import com.github.alexeygorovoy.picturesque.api.data.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface UnsplashApi {

    @GET("photos/random")
    fun getRandomPhoto(): Single<Photo>

    companion object {
        const val AuthorizationHeader = "Authorization"
        fun authorizationHeaderValue(apiKey: String) = "Client-ID $apiKey"
    }
}