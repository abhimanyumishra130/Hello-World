package com.example.roomdatabasemoneymanagerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import com.example.roomdatabasemoneymanagerapp.R
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.RoomDataBase
import kotlinx.android.synthetic.main.fragment_balance_fragement.*

class Balance_fragement : Fragment(R.layout.fragment_balance_fragement) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val roomDataBase = context?.let { RoomDataBase.getDatabaseObject(it) }
        val taskExpenseDao = roomDataBase?.getExpenseDao()
        val taskIncomeDao = roomDataBase?.getIncomeDao()

        var income = 0.0
        var expense = 0.0

        if (taskExpenseDao != null) {
            taskExpenseDao.getSumData().observe(viewLifecycleOwner, Observer {
                if(it == null){
                    expenseId.text = "0.0"
                }else{
                    expenseId.text = it.toString()
                    expense = it

                    totalId.text = (income-expense).toString()
                }
            })
        }

        if (taskIncomeDao != null) {
            taskIncomeDao.getSumData().observe(viewLifecycleOwner, Observer {
                if(it == null){
                    incomeId.text = "0.0"
                }else{
                    incomeId.text = it.toString()
                    income = it

                    totalId.text = (income-expense).toString()
                }
            })
        }
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