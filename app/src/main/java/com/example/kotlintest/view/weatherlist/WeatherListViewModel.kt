package com.example.kotlintest.view.weatherlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlintest.model.Repository
import com.example.kotlintest.model.RepositoryImpl
import com.example.kotlintest.model.RepositoryRemoteImpl
import com.example.kotlintest.viewmodel.AppState

class WeatherListViewModel(private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()) :
    ViewModel() {

    lateinit var repository: Repository

    fun getLiveData(): MutableLiveData<AppState> {
        choiceRepository()
        return liveData
    }

    private fun choiceRepository() {
        repository =
            if (isConnection()) {
                RepositoryRemoteImpl()
            } else {
                RepositoryImpl()
            }
    }

    fun simulateRequestToServer() {

        liveData.value = AppState.Loading

        Thread{
            Thread.sleep(2000L)

        if ((0..3).random() == 1) {
            liveData.postValue(AppState.Error(Throwable("что-то пошло не так")))
        } else {

            liveData.postValue(
                AppState.Success(
                    repository.getWeather(
                        55.353453,
                        37.53463460000034
                    )
                )
            )
        }

        }.start()


    }

    private fun isConnection(): Boolean {
        return false

    }

}