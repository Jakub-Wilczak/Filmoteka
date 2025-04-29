package com.example.swiezak.data

import com.example.swiezak.model.Film

interface FilmRepository {
    fun getFilmList(): List<Film>

    fun getFilmList(category: Int): List<Film>
}