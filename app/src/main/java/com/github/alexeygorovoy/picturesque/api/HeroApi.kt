package com.github.alexeygorovoy.picturesque.api

import com.github.alexeygorovoy.picturesque.api.models.Heroes
import io.reactivex.Single
import retrofit2.http.GET

interface HeroApi {

    @GET("test-mobile/iOS/json/test2.json")
    fun getHeroes(): Single<Heroes>
}
