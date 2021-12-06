package com.example.androidmockassignment_iv.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.androidmockassignment_iv.data.database.Contact
import com.example.androidmockassignment_iv.data.database.ContactDao
import com.example.androidmockassignment_iv.ui.PagingSourceItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class ContactRepo @Inject constructor(val dao:ContactDao) {

    fun insertToDb(contacts:ArrayList<Contact>){
        CoroutineScope(Dispatchers.IO).launch{
            dao.insertContacts(contacts)
        }
    }

    fun getAllContacts():LiveData<List<Contact>>{
        return dao.getAllContacts()
    }

    fun updateContact(contact:Contact){
        CoroutineScope(Dispatchers.IO).launch {
            dao.updateContact(contact)
        }
    }

    fun deleteAll(){
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAll()
        }
    }


    fun getPageList(context: ArrayList<Contact>) = Pager(
        config = PagingConfig(
            pageSize = 20
        ),
        pagingSourceFactory = { PagingSourceItem(context) }
    ).liveData

}