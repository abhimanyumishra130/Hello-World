package com.example.w45_codingevalutation.Data.Local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class ArticleDatabase(

    @ColumnInfo(name = "author")
    var author: String,
    @ColumnInfo(name = "content")
    var content: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "published")
    var publishedAt: String,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "url_image")
    var urlToImage: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int?=null
}