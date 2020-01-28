package com.lysenko.data.db.contracts

class TableSqlContract {

    companion object{

        const val fetchHeroes = "SELECT * FROM ${RoomNamesContract.tableHeroName}"
        const val fetchPlayers = "SELECT * FROM ${RoomNamesContract.playerHeroName}"

    }
}