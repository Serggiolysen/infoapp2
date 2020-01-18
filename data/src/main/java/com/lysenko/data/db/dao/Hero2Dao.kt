package com.lysenko.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.lysenko.data.db.contracts.RoomContract
import com.lysenko.data.db.contracts.Table2SqlContract
import com.lysenko.data.db.model.Hero2Entity

@Dao
interface Hero2Dao {

    @Query("SELECT * FROM ${RoomContract.table2} WHERE id = :id")
    fun fetchHero2(id:Int):List<Hero2Entity>
}