package com.example.itunesapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Music_Table")
data class MusicTable (

    @ColumnInfo(name = "artistName")
    val artistName: String,
    @ColumnInfo(name = "image")
    val artworkUrl30: String,
//    @ColumnInfo(name = "collection artist name")
//    val collectionArtistName: String,
    @ColumnInfo(name = "collection name")
    val collectionName: String?="abhi",
    @ColumnInfo(name = "track URL")
    val trackViewUrl: String
        ){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int? = null
}