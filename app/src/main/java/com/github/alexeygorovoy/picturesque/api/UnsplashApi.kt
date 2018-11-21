package com.github.alexeygorovoy.picturesque.api

import com.github.alexeygorovoy.picturesque.api.data.Photo
import retrofit2.http.GET
import rx.Single

interface UnsplashApi {

    @GET("photos/random")
    fun getRandomPhoto() : Single<Photo>

    companion object {
        const val AuthorizationHeader = "Authorization"
        fun authorizationHeaderValue(apiKey: String) = "Client-ID $apiKey"
    }

}