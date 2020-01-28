package com.lysenko.domain.converters

//import com.lysenko.data.db.model.PlayerEntity
import com.lysenko.data.db.model.PlayerEntity
import com.lysenko.data.remote.helpers.models.PlayersApi
import com.lysenko.domain.models.Player

object PlayerConverterImpl {

    fun convertApiToUI(list: List<PlayersApi>): List<Player> {
        val tmpArrayList = ArrayList<Player>()
        for (it in list) {
            tmpArrayList.add(
                    Player(
                            account_id = it.account_id,
                            avatar = it.avatarmedium,
                            avatarfull = it.avatarfull,
                            personaname = it.personaname,
                            name = it.name,
                            country_code = it.country_code,
                            team_name = it.team_name,
                            is_pro = it.is_pro
                    )
            )
        }
        return tmpArrayList
    }

    fun convertApiToDB(list: List<PlayersApi>): List<PlayerEntity> {
        val tmpArrayList = ArrayList<PlayerEntity>()
        for (it in list) {
            tmpArrayList.add(
                    PlayerEntity(
                            account_id = it.account_id,
                            avatar = it.avatarmedium,
                            avatarfull = it.avatarfull,
                            personaname = it.personaname,
                            name = it.name,
                            country_code = it.country_code,
                            team_name = it.team_name,
                            is_pro = it.is_pro
                    )
            )
        }
        return tmpArrayList
    }

    fun convertDBtoUI(list: List<PlayerEntity>): List<Player> {
        val tmpArrayList = ArrayList<Player>()
        for (it in list) {
            tmpArrayList.add(
                    Player(
                            account_id = it.account_id,
                            avatar = it.avatar,
                            avatarfull = it.avatarfull,
                            personaname = it.personaname,
                            name = it.name,
                            country_code = it.country_code,
                            team_name = it.team_name,
                            is_pro = it.is_pro
                    )
            )
        }
        return tmpArrayList
    }
}