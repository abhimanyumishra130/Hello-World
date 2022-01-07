package com.example.moviedatabase.viewModel

import androidx.lifecycle.ViewModel
import com.example.moviedatabase.repository.Repository

class ItemViewModel : ViewModel() {

    private val repo = Repository()
    fun getAllData() = repo.getPageList()
}