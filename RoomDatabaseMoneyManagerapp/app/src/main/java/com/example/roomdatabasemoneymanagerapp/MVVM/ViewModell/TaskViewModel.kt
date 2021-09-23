package com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.roomdatabasemoneymanagerapp.MVVM.Repository.MoneyRepo
import com.example.roomdatabasemoneymanagerapp.Retrofit.Resource
import com.example.roomdatabasemoneymanagerapp.Retrofit.SignUp.request.SignUpReqestModel
import com.example.roomdatabasemoneymanagerapp.Retrofit.SignUp.response.SignUpResponse
import com.example.roomdatabasemoneymanagerapp.Retrofit.requests.LoginRequestModel
import com.example.roomdatabasemoneymanagerapp.Retrofit.response.LoginResponse
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.ExpenseTable
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.IncomeTable
import kotlinx.coroutines.Dispatchers

class TaskViewModel(val repo: MoneyRepo):ViewModel() {

    fun userLogin(loginRequestModel: LoginRequestModel)
            :LiveData<Resource<LoginResponse>>{
        return liveData(Dispatchers.IO){
            val result = repo.login(loginRequestModel)
            emit(result)
        }
    }

    fun userSignUp(signUpReqestModel: SignUpReqestModel)
            :LiveData<Resource<SignUpResponse>>{
        return liveData(Dispatchers.IO){
            val result = repo.signUp(signUpReqestModel)
            emit(result)
        }
    }


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