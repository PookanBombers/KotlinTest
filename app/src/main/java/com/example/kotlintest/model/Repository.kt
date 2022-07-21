package com.example.kotlintest.model

import com.example.kotlintest.domain.Weather

interface Repository {
    fun getListWeather():List<Weather>
    fun getWeather(lat: Double, lon: Double):Weather
}