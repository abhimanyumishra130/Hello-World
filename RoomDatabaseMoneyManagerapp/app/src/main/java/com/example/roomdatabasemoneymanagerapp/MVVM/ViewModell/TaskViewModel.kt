package com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabasemoneymanagerapp.MVVM.Repository.MoneyRepo
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.ExpenseTable
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.IncomeTable

class TaskViewModel(val repo: MoneyRepo):ViewModel() {
    fun insertIncome(income: IncomeTable){
        repo.addIncomeToRoom(income)
    }
    fun insertExpense(expense:ExpenseTable){
        repo.addExpenseToRoom(expense)
    }

    fun updateIncome(income: IncomeTable){
        repo.updateIncome(income)
    }
    fun updateExpense(expense: ExpenseTable){
        repo.updateExpense(expense)
    }

    fun deleteIncome(income: IncomeTable){
        repo.deleteIncome(income)
    }
    fun deleteExpense(expense: ExpenseTable){
        repo.deleteExpense(expense)
    }

    fun getSumIncome():LiveData<Double>{
        return repo.getSumIncome()
    }
    fun getSumExpense():LiveData<Double>{
        return repo.getSumExpense()
    }

    fun getAllIncome():LiveData<MutableList<IncomeTable>>{
        return repo.getAllIncomeData()
    }
    fun getAllExpense():LiveData<MutableList<ExpenseTable>>{
        return repo.getAllExpenseData()
    }
}