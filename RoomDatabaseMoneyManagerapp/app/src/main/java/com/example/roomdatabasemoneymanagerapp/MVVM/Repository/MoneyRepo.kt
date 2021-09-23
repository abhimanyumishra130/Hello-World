package com.example.roomdatabasemoneymanagerapp.MVVM.Repository

import androidx.lifecycle.LiveData
import com.example.roomdatabasemoneymanagerapp.Retrofit.Network
import com.example.roomdatabasemoneymanagerapp.Retrofit.Resource
import com.example.roomdatabasemoneymanagerapp.Retrofit.ResponseHandler
import com.example.roomdatabasemoneymanagerapp.Retrofit.SignUp.request.SignUpReqestModel
import com.example.roomdatabasemoneymanagerapp.Retrofit.SignUp.response.SignUpResponse
import com.example.roomdatabasemoneymanagerapp.Retrofit.TasksAPI
import com.example.roomdatabasemoneymanagerapp.Retrofit.requests.LoginRequestModel
import com.example.roomdatabasemoneymanagerapp.Retrofit.response.LoginResponse
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.ExpenseTable
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.IncomeTable
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.TaskExpenseDao
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.TaskIncomeDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MoneyRepo(private val taskIncomeDao: TaskIncomeDao, private val taskExpenseDao: TaskExpenseDao) {

    //Creating api object to call
    private val api: TasksAPI = Network.getRetrofit()
        .create(TasksAPI::class.java)

    private val responseHandler = ResponseHandler()
    private val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGE0YmI3OTAzMjdlN2MwNmE2MTk1ODYiLCJpYXQiOjE2MzIxMzg2ODR9.cTxpYQrTfvramIOSPih6b1hJO_x1G-V2GmaRnTYSjU0"



    suspend fun login(loginRequestModel: LoginRequestModel)
            : Resource<LoginResponse> {
        return try {
            val response = api.login(loginRequestModel)

            responseHandler.handleSuccess(response)
        }catch (e: Exception){
            responseHandler.handleException(e)
        }

    }





    suspend fun signUp(signUpReqestModel: SignUpReqestModel):Resource<SignUpResponse>{
        return  try {
             val response = api.signUp(signUpReqestModel)
            responseHandler.handleSuccess(response)
        }catch (e:Exception){
            responseHandler.handleException(e)
        }
    }

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