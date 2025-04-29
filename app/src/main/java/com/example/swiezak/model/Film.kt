package com.example.swiezak.model

import androidx.annotation.DrawableRes

data class Film(
    @DrawableRes
    val filmIcon: Int? =null,
    val name: String,
    val date: String,
    @DrawableRes
    val status: Int,
    val grade: String? =null
    )
