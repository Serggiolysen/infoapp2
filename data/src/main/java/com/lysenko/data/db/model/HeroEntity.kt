package com.lysenko.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lysenko.data.db.contracts.RoomNamesContract

@Entity(tableName = RoomNamesContract.tableHeroName)
data class HeroEntity(
        @PrimaryKey val id: Int,
        val displayName: String,
        val avatar: String,
        val attack_type: Int,
        val image: String
)