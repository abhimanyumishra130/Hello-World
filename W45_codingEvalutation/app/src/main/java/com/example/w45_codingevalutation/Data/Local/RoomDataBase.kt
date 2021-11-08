package com.example.w45_codingevalutation.Data.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.w45_codingevalutation.Data.remote.Article

@Database(entities = [ArticleDatabase::class],version = 1)
abstract class RoomDataBase : RoomDatabase() {

    abstract fun getDao():RoomDao
    companion object{

        private var INSTANCE : RoomDataBase? = null
        fun getObject(context: Context):RoomDataBase{
            if(INSTANCE == null){
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDataBase::class.java,
                    "article"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                return INSTANCE!!
            }
            else return INSTANCE!!
        }
    }



}