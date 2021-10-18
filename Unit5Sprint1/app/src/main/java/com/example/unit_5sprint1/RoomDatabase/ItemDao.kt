package com.example.unit_5sprint1.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.example.unit_5sprint1.retrofit.ResponseModelItem

interface ItemDao {

    @Insert
    fun insertData(model: Model)

    @Query("select * from actors")
    fun getDataFromDB():LiveData<ArrayList<Model>>
}