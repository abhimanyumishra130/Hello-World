package com.example.newsapplication.data.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "News_Table")
data class Article(

    @ColumnInfo(name = "author")
    val author: String? = "Abhi",

    @ColumnInfo(name = "content")
    val content: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "publishedAT")
    val publishedAt: String,


    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "urlToImage")
    val urlToImage: String
):Serializable{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "name")
    var id:Int?=null
}