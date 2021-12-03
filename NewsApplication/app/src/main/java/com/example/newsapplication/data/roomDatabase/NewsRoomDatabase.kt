package com.example.newsapplication.data.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsapplication.data.models.Article


@Database(entities = [Article::class],version = 2)
abstract class NewsRoomDatabase :RoomDatabase(){
    abstract fun getNewsDao():NewsDao

    companion object{
        private var INST :NewsRoomDatabase?=null

        fun getDataBaseObject(context: Context):NewsRoomDatabase{
            if (INST == null){
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    NewsRoomDatabase::class.java,
                    "news_db"
                )

                builder.fallbackToDestructiveMigration()
                INST = builder.build()
                return INST!!
            }else return INST!!
        }
    }
}