package com.lysenko.data.remote.providers

import com.lysenko.data.remote.helpers.RetrofitFactory
import com.lysenko.data.remote.helpers.models.HeroStatApi
import com.lysenko.data.remote.helpers.models.PlayersApi
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import kotlinx.serialization.UnstableDefault

object DotaProviderImpl {

    @UnstableDefault
   suspend fun getHeroStats(): Deferred<List<HeroStatApi>> {
        return RetrofitFactory().getHeroesService().getHeroesStats()
    }

    @UnstableDefault
   suspend fun getPlayers(): Deferred<List<PlayersApi>> {
        return RetrofitFactory().getHeroesService().getPlayers()
    }
}