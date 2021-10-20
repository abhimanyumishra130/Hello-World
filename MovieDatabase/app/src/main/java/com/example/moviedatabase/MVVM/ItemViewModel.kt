package com.example.moviedatabase.MVVM

import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {

    private val repo = Repository()
    fun getAllData() = repo.getPageList()
}