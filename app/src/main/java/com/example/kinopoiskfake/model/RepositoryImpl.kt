package com.example.kinopoiskfake.model

class RepositoryImpl: Repository {
    override fun getFilmsFromServer(): FilmInfo {
        return FilmInfo()
    }

    override fun getFilmInfoFromLocalStorageNovelties() = getNoveltiesFilms()
    override fun getFilmInfoFromLocalStorageHits() = getHitsFilms()
}