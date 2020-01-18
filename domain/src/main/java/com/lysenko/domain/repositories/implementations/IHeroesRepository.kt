package com.lysenko.domain.repositories.implementations

import com.lysenko.data.remote.helpers.models.HeroApi
import com.lysenko.domain.models.Hero
import io.reactivex.Observable

interface IHeroesRepository {
    fun fetchHeroes(): Observable<List<Hero>>
}