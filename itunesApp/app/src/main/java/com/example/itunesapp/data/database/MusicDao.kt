package com.example.itunesapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.itunesapp.data.model.MusicTable

@Dao
interface MusicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMusic(result: MusicTable)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMusics(result:List<MusicTable>)

    @Query("select * from music_table")
    fun getMusics():LiveData<List<MusicTable>>

    @Query("delete from music_table")
    fun deleteMusic()

}