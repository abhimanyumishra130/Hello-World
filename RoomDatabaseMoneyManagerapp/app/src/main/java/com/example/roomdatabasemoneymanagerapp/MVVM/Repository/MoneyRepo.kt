package com.example.roomdatabasemoneymanagerapp.MVVM.Repository

import androidx.lifecycle.LiveData
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.ExpenseTable
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.IncomeTable
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.TaskExpenseDao
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.TaskIncomeDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoneyRepo(private val taskIncomeDao: TaskIncomeDao, private val taskExpenseDao: TaskExpenseDao) {

    fun addIncomeToRoom(income: IncomeTable){
        CoroutineScope(Dispatchers.IO).launch {
            taskIncomeDao.insertData(income)
        }
    }

    fun addExpenseToRoom(expense: ExpenseTable){
        CoroutineScope(Dispatchers.IO).launch {
            taskExpenseDao.insertData(expense)
        }
    }


    fun updateIncome(income: IncomeTable){
        CoroutineScope(Dispatchers.IO).launch {
            taskIncomeDao.updateData(income)
        }
    }

    fun updateExpense(expense: ExpenseTable){
        CoroutineScope(Dispatchers.IO).launch {
            taskExpenseDao.updateData(expense)
        }
    }


    fun deleteIncome(income: IncomeTable){
        CoroutineScope(Dispatchers.IO).launch {
            taskIncomeDao.deleteData(income)
        }
    }

    fun deleteExpense(expense: ExpenseTable){
        CoroutineScope(Dispatchers.IO).launch {
            taskExpenseDao.deleteData(expense)
        }
    }


    fun getSumIncome(): LiveData<Double>{
        return taskIncomeDao.getSumData()
    }

    fun getSumExpense():LiveData<Double>{
       return taskExpenseDao.getSumData()
    }


    fun getAllIncomeData():LiveData<MutableList<IncomeTable>>{
        return taskIncomeDao.getData()
    }
    fun getAllExpenseData():LiveData<MutableList<ExpenseTable>>{
        return taskExpenseDao.getData()
    }
}