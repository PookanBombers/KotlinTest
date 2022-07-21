package com.example.kotlintest.model

import com.example.kotlintest.domain.Weather

class RepositoryImpl:Repository {
    override fun getListWeather(): List<Weather> {
        return listOf(Weather())
    }

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }

}