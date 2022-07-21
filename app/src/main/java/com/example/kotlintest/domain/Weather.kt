package com.example.kotlintest.domain

data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = 30,
    val feelsLike: Int = 35
)

data class City(
    val city: String,
    val lat: Double,
    val lon: Double
)

fun getDefaultCity() = City("Севастополь", 55.353453, 37.53463460000034)