package com.example.newsapplication.di

import android.content.Context
import androidx.room.Room
import com.example.newsapplication.data.roomDatabase.NewsDao
import com.example.newsapplication.data.roomDatabase.NewsRoomDatabase
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
object NewsModule {

    @Provides
    @Singleton
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    @Provides
    @Singleton
    fun provideRoomDB(@ApplicationContext context:Context):NewsRoomDatabase{
        val builder = Room.databaseBuilder(
            context.applicationContext,
            NewsRoomDatabase::class.java,
            "news_db"
        )

        builder.fallbackToDestructiveMigration()
       return builder.build()
    }

    @Provides
    @Singleton
    fun provideDao(DB:NewsRoomDatabase):NewsDao{
        return DB.getNewsDao()
    }
}