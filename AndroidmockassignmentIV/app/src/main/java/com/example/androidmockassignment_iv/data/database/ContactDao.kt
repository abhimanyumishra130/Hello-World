package com.example.androidmockassignment_iv.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {

    @Insert
    fun insertContacts(contacts:ArrayList<Contact>)

    @Update
    fun updateContact(contact:Contact)

    @Query("delete from contact_table")
    fun deleteAll()

    @Query("select * from Contact_Table order by Rank DESC")
    fun getAllContacts():LiveData<List<Contact>>
}