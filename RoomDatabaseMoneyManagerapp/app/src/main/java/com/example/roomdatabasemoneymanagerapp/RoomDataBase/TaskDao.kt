package com.example.roomdatabasemoneymanagerapp.RoomDataBase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskIncomeDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(incomeTable: IncomeTable)

    @Update
    fun updateData(incomeTable: IncomeTable)

    @Delete
    fun deleteData(incomeTable: IncomeTable)

    @Query("select * from income")
    fun getData() : LiveData<MutableList<IncomeTable>>

    @Query("select sum(amount) as total from income")
    fun getSumData() :  LiveData<Double>
}


@Dao
interface TaskExpenseDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(incomeTable: ExpenseTable)

    @Update
    fun updateData(incomeTable: ExpenseTable)

    @Delete
    fun deleteData(incomeTable: ExpenseTable)

    @Query("select * from expense")
    fun getData() : LiveData<MutableList<ExpenseTable>>

    @Query("select sum(amount) as total from expense")
    fun getSumData() : LiveData<Double>
}