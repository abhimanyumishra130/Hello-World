package com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabasemoneymanagerapp.MVVM.Repository.MoneyRepo

class TaskViewModelFactory(val moneyRepo: MoneyRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TaskViewModel(moneyRepo) as T

    }
}