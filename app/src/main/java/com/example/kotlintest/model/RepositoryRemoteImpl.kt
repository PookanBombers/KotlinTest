package com.example.kotlintest.model

import com.example.kotlintest.domain.Weather
import com.example.kotlintest.viewmodel.AppState

class RepositoryRemoteImpl:Repository {
    override fun getListWeather(): List<Weather> {
        return listOf(Weather())
    }

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }
}