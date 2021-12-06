package com.example.androidmockassignment_iv.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.androidmockassignment_iv.data.database.Contact
import com.example.androidmockassignment_iv.repository.ContactRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(val repo:ContactRepo):ViewModel() {

    fun insertToDb(contacts:ArrayList<Contact>){
      repo.insertToDb(contacts)
    }

    fun getAllContacts():LiveData<List<Contact>>{
        return repo.getAllContacts()
    }

    fun updateContact(contact:Contact){
        repo.updateContact(contact)
    }

    fun deleteAll(){
        repo.deleteAll()
    }

    fun getAllData(context:ArrayList<Contact>) = repo.getPageList(context)
}