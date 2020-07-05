package com.github.alexeygorovoy.picturesque.ui.common

sealed class Result<T> {
    class Data<T>(val data: T) : Result<T>()
    class Error(val throwable: Throwable): Result<Any>()
}
