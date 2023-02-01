package com.example.kinopoiskfake.viewmodel

import com.example.kinopoiskfake.model.FilmInfo

sealed class AppState {
    data class Success(val filmData: FilmInfo): AppState()
    data class Error(val Error: Throwable): AppState()
    object Loading: AppState()
}
