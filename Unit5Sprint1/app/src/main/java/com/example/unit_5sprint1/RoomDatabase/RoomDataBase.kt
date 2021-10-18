package com.example.unit_5sprint1.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Model::class],version = 1)
abstract class ActorRoomDataBase: RoomDatabase() {

    abstract fun getDao():ItemDao
    companion object{
        private var INSTANCE : ActorRoomDataBase?=null
        fun databaseObject(context: Context):ActorRoomDataBase{
            if(INSTANCE==null){
                val obj = Room.databaseBuilder(
                    context.applicationContext,
                    ActorRoomDataBase::class.java,
                    "actors1"
                )

                obj.fallbackToDestructiveMigration()
                INSTANCE = obj.build()
                return INSTANCE!!
            }
            else return INSTANCE!!
        }
    }
}