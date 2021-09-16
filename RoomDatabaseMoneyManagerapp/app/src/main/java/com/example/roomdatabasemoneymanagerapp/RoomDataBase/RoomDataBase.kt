package com.example.roomdatabasemoneymanagerapp.RoomDataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [IncomeTable::class,ExpenseTable::class],version = 1)
abstract class RoomDataBase: RoomDatabase() {

    abstract fun getIncomeDao():TaskIncomeDao
    abstract fun getExpenseDao():TaskExpenseDao


    companion object{
        private var INSTANCE:RoomDataBase? = null

        fun getDatabaseObject(context: Context) :RoomDataBase{

            if (INSTANCE == null){
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDataBase::class.java,
                    "db_name")

                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                return INSTANCE!!
            }
            else return INSTANCE!!

        }

    }
}