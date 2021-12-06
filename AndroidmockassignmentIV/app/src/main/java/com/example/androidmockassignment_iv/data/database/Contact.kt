package com.example.androidmockassignment_iv.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact_Table")
data class Contact(
    @ColumnInfo(name = "name")
    val name:String,
    @ColumnInfo(name = "Phone_Number")
    val phoneNumber:String,
    @ColumnInfo(name = "Rank")
    var rank:Int?=0
) {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}