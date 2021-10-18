package com.example.unit_5sprint1.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(model: Model)

    @Query("select * from actors")
    fun getDataFromDB():LiveData<List<Model>>

    @Query("delete from actors")
    fun deleteAll()
}