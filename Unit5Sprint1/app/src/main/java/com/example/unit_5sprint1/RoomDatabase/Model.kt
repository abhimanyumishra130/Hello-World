package com.example.unit_5sprint1.RoomDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "actors")
class Model(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int,
    @ColumnInfo(name = "name")
    var name :String,
    @ColumnInfo(name = "birthday")
    var birthDay:String,
    @ColumnInfo(name = "deathday")
    var deathday:String,
    @ColumnInfo(name = "imageURl")
    var imageUrl:String,
    @ColumnInfo(name = "country name")
    var countryName:String,
    @ColumnInfo(name = "country code")
    var countryCode:String,
    @ColumnInfo(name = "country time-zone")
    var timeZone:String
)