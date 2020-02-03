package com.lysenko.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lysenko.data.db.contracts.RoomNamesContract

@Entity(tableName = RoomNamesContract.playerHeroName)
data class PlayerEntity(
        @PrimaryKey val account_id: Int,
        val avatar: String?,
        val avatarfull: String?,
        val personaname: String?,
        val name: String?,
        val country_code: String?,
//        val team_name:  String?,
        val is_pro: Boolean

)