package com.example.kinopoiskfake.model

interface Repository {
    fun getFilmsFromServer(): FilmInfo
    fun getFilmInfoFromLocalStorageNovelties(): List<FilmInfo>
    fun getFilmInfoFromLocalStorageHits(): List<FilmInfo>
}