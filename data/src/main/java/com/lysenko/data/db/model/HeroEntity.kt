package com.lysenko.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lysenko.data.db.contracts.RoomContract

@Entity(tableName = RoomContract.tableHero)
data class HeroEntity(
        @PrimaryKey val id: Int,
        val displayName: String,
        val avatar: String,
        val attack_type: Int
)