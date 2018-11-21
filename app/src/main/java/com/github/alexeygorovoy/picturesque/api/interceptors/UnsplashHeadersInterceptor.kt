package com.github.alexeygorovoy.picturesque.api.interceptors

import com.github.alexeygorovoy.picturesque.api.UnsplashApi
import okhttp3.Interceptor
import okhttp3.Response

class UnsplashHeadersInterceptor (
    private val apiKey: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader(UnsplashApi.AuthorizationHeader, UnsplashApi.authorizationHeaderValue(apiKey))
            .build()

        return chain.proceed(request)
    }
}