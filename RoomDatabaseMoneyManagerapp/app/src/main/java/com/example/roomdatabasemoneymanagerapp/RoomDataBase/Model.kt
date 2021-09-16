package com.example.roomdatabasemoneymanagerapp.RoomDataBase


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Income")
data class IncomeTable(@ColumnInfo(name = "amount") var amount:Double,
                       @ColumnInfo(name = "desc") var desc:String,
                       @ColumnInfo(name = "date") var date:String)  {

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")  var id:Int? =null

}

@Entity(tableName = "Expense")
data class ExpenseTable(@ColumnInfo(name = "amount") var amount:Double,
                        @ColumnInfo(name = "desc") var desc:String,
                        @ColumnInfo(name = "date") var date:String)  {

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")  var id:Int? =null

}