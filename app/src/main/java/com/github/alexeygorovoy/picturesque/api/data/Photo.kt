package com.github.alexeygorovoy.picturesque.api.data

data class Photo(
    val errors: List<String>?,
    val id: String,
    val created_at: String,
    val updated_at: String,
    val width: Int,
    val height: Int,
    val color: String,
    val description: String,
    val urls: PhotoUrls,
    val views: Int,
    val downloads: Int
)

data class PhotoUrls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
)