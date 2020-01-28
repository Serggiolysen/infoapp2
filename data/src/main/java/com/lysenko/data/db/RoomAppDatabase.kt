package com.lysenko.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lysenko.data.db.contracts.RoomNamesContract
import com.lysenko.data.db.dao.HeroDao
import com.lysenko.data.db.dao.PlayerDao
import com.lysenko.data.db.model.HeroEntity
import com.lysenko.data.db.model.PlayerEntity


@Database(entities = [HeroEntity::class, PlayerEntity::class], version = 2)
abstract class RoomAppDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun playerDao(): PlayerDao

    companion object {
        fun buildDataSource(context: Context): RoomAppDatabase =
                Room.databaseBuilder(context, RoomAppDatabase::class.java, RoomNamesContract.databaseApp)
                        .fallbackToDestructiveMigration()
                        .build()
    }
}