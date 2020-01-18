package com.lysenko.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lysenko.data.db.contracts.RoomContract
import com.lysenko.data.db.dao.Hero2Dao
import com.lysenko.data.db.dao.HeroDao
import com.lysenko.data.db.model.Hero2Entity
import com.lysenko.data.db.model.HeroEntity

@Database(entities = [HeroEntity::class, Hero2Entity::class], version = 1)
abstract class RoomAppDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun hero2Dao(): Hero2Dao

    companion object {
        fun buildDataSource(context: Context): RoomAppDatabase =
                Room.databaseBuilder(context, RoomAppDatabase::class.java, RoomContract.databaseApp)
                        .build()

    }
}