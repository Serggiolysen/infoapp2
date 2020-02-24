package com.lysenko.data.remote.providers

import com.lysenko.data.di.DaggerDataComponent
import com.lysenko.data.remote.helpers.RetrofitFactory
import com.lysenko.data.remote.helpers.models.HeroStatApi
import com.lysenko.data.remote.helpers.models.PlayersApi
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import kotlinx.serialization.UnstableDefault
import javax.inject.Inject

class DotaProviderImpl
@Inject constructor() : IDotaProvider {

    companion object {
        val retrofitFactory = DaggerDataComponent.create().getRetrofit()
    }

    @UnstableDefault
    override fun getHeroStats(): Deferred<List<HeroStatApi>> {
        return retrofitFactory.getHeroesService().getHeroesStats()
    }

    @UnstableDefault
    override fun getPlayers(): Deferred<List<PlayersApi>> {
        return retrofitFactory.getHeroesService().getPlayers()
    }
}