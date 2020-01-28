package com.lysenko.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lysenko.data.db.contracts.TableSqlContract
import com.lysenko.data.db.model.PlayerEntity
import io.reactivex.Observable

@Dao
interface PlayerDao {

    @Query(TableSqlContract.fetchPlayers)
    fun fetchPlayers(): Observable<List<PlayerEntity>>

    @Insert(entity = PlayerEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayer(playerEntityList: List<PlayerEntity>)

}