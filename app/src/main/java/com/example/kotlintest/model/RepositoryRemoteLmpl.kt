package com.example.kotlintest.model

import com.example.kotlintest.domain.Weather
import com.example.kotlintest.viewmodel.AppState

class RepositoryRemoteLmpl:Repository {
    override fun getListWeather(): List<Weather> {
        Thread{
            Thread.sleep(200L)
        }.start()
        return listOf(Weather())
    }

    override fun getWeather(lat: Double, lon: Double): Weather {
        Thread{
            Thread.sleep(300L)
        }.start()
        return Weather()
    }
}