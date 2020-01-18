package com.lysenko.data.db.contracts

class TableHeroSqlContract {

    companion object{

        const val fetch = "SELECT * FROM ${RoomContract.tableHero}"
    }
}