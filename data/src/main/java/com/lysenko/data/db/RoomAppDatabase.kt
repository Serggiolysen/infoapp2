package com.lysenko.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lysenko.data.db.contracts.RoomNamesContract
import com.lysenko.data.db.dao.HeroDao
import com.lysenko.data.db.model.HeroEntity

@Database(entities = [HeroEntity::class], version = 1)
abstract class RoomAppDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    companion object {
        fun buildDataSource(context: Context): RoomAppDatabase =
                Room.databaseBuilder(context, RoomAppDatabase::class.java, RoomNamesContract.databaseApp)
                        .build()

    }




}