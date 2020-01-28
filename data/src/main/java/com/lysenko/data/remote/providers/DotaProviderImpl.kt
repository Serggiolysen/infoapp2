package com.lysenko.data.remote.providers

import com.lysenko.data.remote.helpers.RetrofitFactory
import com.lysenko.data.remote.helpers.models.HeroStatApi
import com.lysenko.data.remote.helpers.models.PlayersApi
import io.reactivex.Observable

object DotaProviderImpl {

    fun getHeroStats(): Observable<List<HeroStatApi>> {
        return RetrofitFactory().getHeroesService().getHeroesStats()
    }

    fun getPlayers(): Observable<List<PlayersApi>> {
        return RetrofitFactory().getHeroesService().getPlayers()
    }
}