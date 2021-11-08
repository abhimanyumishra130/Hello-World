package com.example.w45_codingevalutation.Data.remote

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class Article(

    @ColumnInfo(name = "author")
    val author: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "published_date")
    val publishedAt: String,
    val source: Source,
    @ColumnInfo(name = "title")
    val title: String,
    val url: String,
    @ColumnInfo(name = "image_url")
    val urlToImage: Any
)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int?=null
}