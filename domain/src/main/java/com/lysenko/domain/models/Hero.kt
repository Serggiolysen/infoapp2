package com.lysenko.domain.models

data class Hero(
    val id: Int, val title: String, val icon: String, val attackType: Int
) : IHero