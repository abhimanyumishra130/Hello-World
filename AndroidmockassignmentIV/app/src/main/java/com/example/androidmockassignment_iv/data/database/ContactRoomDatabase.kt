package com.example.androidmockassignment_iv.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class],version = 1)
abstract class ContactRoomDatabase:RoomDatabase() {
    abstract fun getContactDao():ContactDao
}