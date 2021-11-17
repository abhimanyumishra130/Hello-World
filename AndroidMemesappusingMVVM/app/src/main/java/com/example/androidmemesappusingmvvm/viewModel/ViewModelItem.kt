package com.example.androidmemesappusingmvvm.viewModel

import androidx.lifecycle.ViewModel
import com.example.androidmemesappusingmvvm.repository.ItemRepo

class ViewModelItem:ViewModel() {

    private val repo = ItemRepo()
    fun getData() = repo.PagerItem()
}