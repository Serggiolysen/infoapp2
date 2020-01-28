package com.lysenko.infoapp.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.lysenko.data.db.RoomAppDatabase
import kotlin.properties.Delegates

class App : Application() {
    lateinit var prefs: SharedPreferences
    lateinit var editor: SharedPreferences.Editor


    companion object {
        var totalCount by Delegates.notNull<Int>()
        lateinit var roomDataBase: RoomAppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        roomDataBase = RoomAppDatabase.buildDataSource(context = applicationContext)

        prefs = getSharedPreferences("FileWithAppStarts", Context.MODE_PRIVATE)

        editor = prefs.edit()

        totalCount = prefs.getInt("counter", -1)
        totalCount++
        editor.putInt("counter", totalCount)
        editor.commit()
        Log.e("AAAA", totalCount.toString())
    }
}