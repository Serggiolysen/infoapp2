package com.lysenko.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lysenko.data.db.contracts.TableHeroSqlContract
import com.lysenko.data.db.model.HeroEntity
import io.reactivex.Observable

@Dao
interface HeroDao {

    @Query(TableHeroSqlContract.fetch)
    fun fetchHeroes(): Observable<List<HeroEntity>>

    @Insert(entity = HeroEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertHero(heroEntityList: List<HeroEntity>)

    @Query(TableHeroSqlContract.fetch)
    fun fetchHeroesList(): List<HeroEntity>
}