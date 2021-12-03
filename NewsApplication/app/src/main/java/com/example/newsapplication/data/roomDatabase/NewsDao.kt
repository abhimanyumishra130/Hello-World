package com.example.newsapplication.data.roomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.newsapplication.data.models.Article


@Dao
interface NewsDao {
    @Insert
    fun insertData(article: List<Article>)

    @Query("select * from News_Table")
    fun getAllNews(): LiveData<List<Article>>

    @Query("delete from News_Table")
    fun deleteAll()

}