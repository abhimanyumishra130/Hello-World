package com.example.androidshorttake_awayassignment_i.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidshorttake_awayassignment_i.repository.Repo

class ViewModelFactory(val repo: Repo) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(repo) as T
    }
}