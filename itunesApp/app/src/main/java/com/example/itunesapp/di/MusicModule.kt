package com.example.itunesapp.di

import android.content.Context
import androidx.room.Room
import com.example.itunesapp.data.database.MusicDao
import com.example.itunesapp.data.database.MusicRoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MusicModule {


    @Provides
    @Singleton
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    @Provides
    @Singleton
    fun provideRoomDb(@ApplicationContext context: Context):MusicRoomDataBase{
        val builder = Room.databaseBuilder(
            context,MusicRoomDataBase::class.java,
            "task_db"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(db:MusicRoomDataBase): MusicDao{
        return db.getMusicDao()
    }
}