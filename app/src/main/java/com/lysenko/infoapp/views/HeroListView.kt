package com.lysenko.infoapp.views

import com.lysenko.domain.models.Hero

interface HeroListView{
    fun showHeroes(listWithHeroes: List<Hero>)
    fun showLoading()
}