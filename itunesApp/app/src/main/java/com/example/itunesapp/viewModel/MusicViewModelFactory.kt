package com.example.itunesapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itunesapp.repository.MusicRepo

class MusicViewModelFactory(val repo: MusicRepo) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MusicViewModel(repo) as T
    }
}