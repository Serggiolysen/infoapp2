package com.lysenko.data.db.contracts

class Table2SqlContract {

    companion object{

        const val fetch = "SELECT * FROM ${RoomContract.table2} WHERE id = [HERO_ID]"
    }
}