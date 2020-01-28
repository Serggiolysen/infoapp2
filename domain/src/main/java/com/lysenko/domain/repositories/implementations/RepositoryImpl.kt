package com.lysenko.domain.repositories.implementations

import android.util.Log
import com.lysenko.data.db.RoomAppDatabase
import com.lysenko.data.remote.providers.DotaProviderImpl
import com.lysenko.domain.converters.HeroConverterImpl
import com.lysenko.domain.converters.PlayerConverterImpl
import com.lysenko.domain.models.Hero
import com.lysenko.domain.models.Player
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryImpl(private var roomAppDatabase: RoomAppDatabase,
                     private var totalAppStartsCount: Int)
    : IRepository {

    override fun fetchHeroes(): Observable<List<Hero>> {

        val observsbleListHeroFromNet = DotaProviderImpl.getHeroStats().map {
            roomAppDatabase.heroDao().insertHero(HeroConverterImpl.convertApiToDB(it))
            HeroConverterImpl.convertApiToUI(it)
        }.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())

        val observsbleListHeroFromDB = roomAppDatabase.heroDao().fetchHeroes().map {
            HeroConverterImpl.convertDBtoUI(it)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        return if ((totalAppStartsCount % 20) == 0) {
            observsbleListHeroFromNet
        } else observsbleListHeroFromDB

    }

    override fun fetchPlayers(): Observable<List<Player>> {

        val observsbleListPlayersFromNet = DotaProviderImpl.getPlayers().map {
            roomAppDatabase.playerDao().insertPlayer(PlayerConverterImpl.convertApiToDB(it))
            PlayerConverterImpl.convertApiToUI(it)
        }.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())

        val observsbleListPlayersFromDB = roomAppDatabase.playerDao().fetchPlayers().map {
            PlayerConverterImpl.convertDBtoUI(it)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        return if ((totalAppStartsCount % 20) == 0) {
            observsbleListPlayersFromNet
        } else observsbleListPlayersFromDB

    }
}
