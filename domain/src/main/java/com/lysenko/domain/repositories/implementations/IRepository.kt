package com.lysenko.domain.repositories.implementations

import com.lysenko.data.remote.helpers.models.PlayersApi
import com.lysenko.domain.models.Hero
import com.lysenko.domain.models.Player
import io.reactivex.Observable

interface IRepository {
    fun fetchHeroes(): Observable<List<Hero>>
    fun fetchPlayers(): Observable<List<Player>>
}