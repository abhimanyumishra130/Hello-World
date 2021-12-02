package com.example.itunesapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.itunesapp.data.model.MusicTable

@Database(entities = [MusicTable::class], version = 2)
abstract class MusicRoomDataBase:RoomDatabase() {
    abstract fun getMusicDao():MusicDao

    companion object{
        private var INSTANCE:MusicRoomDataBase ?= null

        fun getDatabaseObject(context: Context) :MusicRoomDataBase{

            if (INSTANCE == null){
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    MusicRoomDataBase::class.java,
                    "db_name")

                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                return INSTANCE!!
            }
            else return INSTANCE!!

        }
    }
}