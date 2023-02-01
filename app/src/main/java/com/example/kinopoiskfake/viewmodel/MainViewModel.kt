package com.example.kinopoiskfake.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kinopoiskfake.model.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RepositoryImpl = RepositoryImpl()
): ViewModel() {

    fun getLiveData(): LiveData<AppState> {
        return liveData
    }

    fun getFilmInfo() {
        Thread {
            liveData.postValue(AppState.Loading)
            sleep(2000L)
            liveData.postValue(AppState.Success(repository.getFilmsFromLocalStorage()))
        }.start()
    }
}