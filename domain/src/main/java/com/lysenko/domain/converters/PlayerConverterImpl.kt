package com.lysenko.domain.converters

//import com.lysenko.data.db.model.PlayerEntity
import com.lysenko.data.db.model.PlayerEntity
import com.lysenko.data.remote.helpers.models.PlayersApi
import com.lysenko.domain.models.Player

object PlayerConverterImpl {

    fun convertApiToUI(playersApi: PlayersApi): Player {
        return Player(
                account_id = playersApi.account_id,
                avatar = playersApi.avatarmedium,
                avatarfull = playersApi.avatarfull,
                personaname = playersApi.personaname,
                name = playersApi.name,
                country_code = playersApi.country_code,
//                team_name = playersApi.team_name,
                is_pro = playersApi.is_pro
        )
    }

    fun convertApiToDB(playersApi: PlayersApi): PlayerEntity {
        return PlayerEntity(
                account_id = playersApi.account_id,
                avatar = playersApi.avatarmedium,
                avatarfull = playersApi.avatarfull,
                personaname = playersApi.personaname,
                name = playersApi.name,
                country_code = playersApi.country_code,
//                team_name = playersApi.team_name,
                is_pro = playersApi.is_pro
        )
    }

    fun convertDBtoUI(listEntity: PlayerEntity): Player {
        return Player(
                account_id = listEntity.account_id,
                avatar = listEntity.avatar,
                avatarfull = listEntity.avatarfull,
                personaname = listEntity.personaname,
                name = listEntity.name,
                country_code = listEntity.country_code,
//                team_name = listEntity.team_name,
                is_pro = listEntity.is_pro
        )
    }
}