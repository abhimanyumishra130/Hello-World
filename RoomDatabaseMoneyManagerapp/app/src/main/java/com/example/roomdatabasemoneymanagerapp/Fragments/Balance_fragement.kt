package com.example.roomdatabasemoneymanagerapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.roomdatabasemoneymanagerapp.MVVM.Repository.MoneyRepo
import com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell.TaskViewModel
import com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell.TaskViewModelFactory
import com.example.roomdatabasemoneymanagerapp.R
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.RoomDataBase
import kotlinx.android.synthetic.main.fragment_balance_fragement.*

class Balance_fragement : Fragment(R.layout.fragment_balance_fragement) {

    lateinit var viewModel:TaskViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val roomDataBase = context?.let { RoomDataBase.getDatabaseObject(it) }
        val taskExpenseDao = roomDataBase?.getExpenseDao()
        val taskIncomeDao = roomDataBase?.getIncomeDao()

        val repo = taskExpenseDao?.let { MoneyRepo(taskIncomeDao!!, it) }
        val taskViewModelFactory = repo?.let { TaskViewModelFactory(it) }

        viewModel = ViewModelProviders.of(this,taskViewModelFactory).get(TaskViewModel::class.java)

        var income = 0.0
        var expense = 0.0

//        if (taskExpenseDao != null) {
//            taskExpenseDao.getSumData().observe(viewLifecycleOwner, Observer {
//                if(it == null){
//                    expenseId.text = "0.0"
//                }else{
//                    expenseId.text = it.toString()
//                    expense = it
//
//                    totalId.text = (income-expense).toString()
//                }
//            })
//        }

        viewModel.getSumExpense().observe(viewLifecycleOwner, Observer {
            if(it == null){
                expenseId.text = "0.0"
                expense = 0.0
                if (income == 0.0) totalId.text = "0.0"
                else totalId.text = income.toString()
            }else{
                expenseId.text = it.toString()
                expense = it

                totalId.text = (income-expense).toString()
            }
        })

//        if (taskIncomeDao != null) {
//            taskIncomeDao.getSumData().observe(viewLifecycleOwner, Observer {
//                if(it == null){
//                    incomeId.text = "0.0"
//                }else{
//                    incomeId.text = it.toString()
//                    income = it
//
//                    totalId.text = (income-expense).toString()
//                }
//            })
//        }

        viewModel.getSumIncome().observe(viewLifecycleOwner, Observer {
            if(it == null){
                incomeId.text = "0.0"
                income = 0.0
                if (expense == 0.0) totalId.text = "0.0"
                else totalId.text = expense.toString()
            }else{
                incomeId.text = it.toString()
                income = it

                totalId.text = (income-expense).toString()
            }
        })
//        val dbHelper = DatabaseHelper(context)
//        val liveData = LIveData()

//        incomeId.text = dbHelper.getIncomeBalance().toString()
//        expenseId.text = dbHelper.getExpenseBalance().toString()
//        totalId.text =(dbHelper.getIncomeBalance()-dbHelper.getExpenseBalance()).toString()
//
//
//        liveData.getIncomeCountData().observe(viewLifecycleOwner, Observer {
//            incomeId.text = it
//        })
//
//        liveData.getExpenseCountData().observe(viewLifecycleOwner, Observer {
//            expenseId.text = it
//        })
//
//        liveData.getTotalCountData().observe(viewLifecycleOwner, Observer {
//            totalId.text = it
//        })

    }



}