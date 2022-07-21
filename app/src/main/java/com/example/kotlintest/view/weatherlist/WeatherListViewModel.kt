package com.example.kotlintest.view.weatherlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlintest.model.Repository
import com.example.kotlintest.model.RepositoryImpl
import com.example.kotlintest.model.RepositoryRemoteLmpl
import com.example.kotlintest.viewmodel.AppState
import java.lang.IllegalStateException
import java.lang.Thread.sleep

class WeatherListViewModel (private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>(),):ViewModel() {

    lateinit var repository:Repository

    fun getLiveData(): MutableLiveData<AppState>{
        choiceRepository()
        return liveData
    }
   private fun choiceRepository(){
       if(isConnection()){
            repository = RepositoryRemoteLmpl()
        }else{
            repository = RepositoryImpl()
        }
    }

    fun sentRequest(){

        liveData.value = AppState.Loading
        if ((0..3).random()==1){
            liveData.postValue(AppState.Error(throw IllegalStateException("что-то пошло не так")))
        }else{
            liveData.postValue(AppState.Success(repository.getWeather(55.353453, 37.53463460000034)))
        }
    }

    private fun isConnection(): Boolean {
        return false

    }

}