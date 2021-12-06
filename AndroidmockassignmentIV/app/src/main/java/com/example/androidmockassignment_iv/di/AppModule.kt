package com.example.androidmockassignment_iv.di

import android.content.Context
import androidx.room.Room
import com.example.androidmockassignment_iv.data.database.ContactDao
import com.example.androidmockassignment_iv.data.database.ContactRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): ContactRoomDatabase {
        val builder = Room.databaseBuilder(
            context,
            ContactRoomDatabase::class.java,
            "db_name"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Provides
    @Singleton
    fun providesDao(db:ContactRoomDatabase):ContactDao{
        return db.getContactDao()
    }

}