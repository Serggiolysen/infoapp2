package com.lysenko.domain.repositories.implementations

import com.lysenko.data.remote.helpers.models.PlayersApi
import com.lysenko.domain.models.Hero
import com.lysenko.domain.models.Player
import kotlinx.coroutines.Deferred

interface IRepository {
    suspend fun fetchHero(): Deferred<List<Hero>>
    suspend fun fetchPlayers(): Deferred<List<Player>>
}