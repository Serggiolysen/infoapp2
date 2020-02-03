package com.lysenko.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lysenko.data.db.contracts.TableSqlContract
import com.lysenko.data.db.model.HeroEntity
import io.reactivex.Observable

@Dao
interface HeroDao {

    @Query(TableSqlContract.fetchHeroes)
    fun fetchHeroes(): List<HeroEntity>

    @Insert(entity = HeroEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertHero(heroEntity: HeroEntity)

}