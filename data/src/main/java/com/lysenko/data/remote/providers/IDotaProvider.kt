package com.lysenko.data.remote.providers

import com.lysenko.data.remote.helpers.models.HeroStatApi
import com.lysenko.data.remote.helpers.models.PlayersApi
import kotlinx.coroutines.Deferred

interface IDotaProvider {

    fun getHeroStats(): Deferred<List<HeroStatApi>>

    fun getPlayers(): Deferred<List<PlayersApi>>
}