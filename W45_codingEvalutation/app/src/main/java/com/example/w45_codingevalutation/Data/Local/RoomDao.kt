package com.example.w45_codingevalutation.Data.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RoomDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(article: ArticleDatabase)

    @Query("select * from article")
    fun getFromDataBase():List<ArticleDatabase>
}