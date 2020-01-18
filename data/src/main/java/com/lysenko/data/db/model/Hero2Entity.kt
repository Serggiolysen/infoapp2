package com.lysenko.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lysenko.data.db.contracts.RoomContract

@Entity(tableName = RoomContract.table2)
data class Hero2Entity(
        @PrimaryKey val id:Int,
        val antiPickID:Int,
        val displayName:String,
        val avatar:String,
        val role:String
)