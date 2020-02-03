package com.lysenko.domain.repositories.implementations

import com.lysenko.data.db.RoomAppDatabase
import com.lysenko.data.remote.providers.DotaProviderImpl
import com.lysenko.domain.converters.HeroConverterImpl
import com.lysenko.domain.converters.PlayerConverterImpl
import com.lysenko.domain.models.Hero
import com.lysenko.domain.models.Player
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class RepositoryImpl(
    private var roomAppDatabase: RoomAppDatabase,
    private var totalAppStartsCount: Int
) : IRepository {

    override suspend fun fetchHero(): Deferred<List<Hero>> {

        return GlobalScope.async {

            val listHeroStstsFromApi = DotaProviderImpl.getHeroStats().await()
            val listHeroEntityFromDB = roomAppDatabase.heroDao().fetchHeroes()

            if (listHeroEntityFromDB.isEmpty()||((totalAppStartsCount%20)!=0)) {
                listHeroStstsFromApi.map {
                    roomAppDatabase.heroDao().insertHero(HeroConverterImpl.convertApiToDB(it))
                    println("AAAA  герои в базу данных из ретрофита: ${it::class.java.simpleName}")
                    HeroConverterImpl.convertApiToUI(it)
                }
            } else listHeroEntityFromDB.map {
                println("AAAA герои из базы данных: ${it::class.java.simpleName}")
                HeroConverterImpl.convertDBtoUI(it)
            }

        }
    }

    override suspend fun fetchPlayers(): Deferred<List<Player>> {

        return GlobalScope.async {

            val listPlayersFromApi = DotaProviderImpl.getPlayers().await()
            val listPlayersEntityFromDB = roomAppDatabase.playerDao().fetchPlayers()

            if (listPlayersEntityFromDB.isEmpty()||((totalAppStartsCount%20)!=0)) {
                listPlayersFromApi.map {
                    roomAppDatabase.playerDao().insertPlayer(PlayerConverterImpl.convertApiToDB(it))
                    println("AAAA  игроки в базу данных из ретрофита: ${it::class.java.simpleName}")
                    PlayerConverterImpl.convertApiToUI(it)
                }
            } else listPlayersEntityFromDB.map {
                println("AAAA  игроки из базы данных: ${it::class.java.simpleName}")
                PlayerConverterImpl.convertDBtoUI(it)
            }

        }
    }

}

