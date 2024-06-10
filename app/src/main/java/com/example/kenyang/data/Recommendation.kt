package com.example.kenyang.data

data class Recommendation(
    val imageId: Int,
    val menu: String,
    val restaurant: String,
    val stock: Int,
    val rating: Double,
    val distance: Double,
    val price: Int
)
