package com.example.kinopoiskfake.model

class RepositoryImpl: Repository {
    override fun getFilmsFromServer(): FilmInfo {
        return FilmInfo()
    }

    override fun getFilmsFromLocalStorage(): FilmInfo {
        return FilmInfo()
    }
}