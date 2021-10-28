package com.example.roomdatabasemoneymanagerapp.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.roomdatabasemoneymanagerapp.MVVM.Repository.MoneyRepo
import com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell.TaskViewModel
import com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell.TaskViewModelFactory
import com.example.roomdatabasemoneymanagerapp.R
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.RoomDataBase
import kotlinx.android.synthetic.main.fragment_balance_fragement.*
import kotlin.math.abs

class Balance_fragement : Fragment(R.layout.fragment_balance_fragement) {

    lateinit var viewModel: TaskViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val roomDataBase = context?.let { RoomDataBase.getDatabaseObject(it) }
        val taskExpenseDao = roomDataBase?.getExpenseDao()
        val taskIncomeDao = roomDataBase?.getIncomeDao()

        val repo = taskExpenseDao?.let { MoneyRepo(taskIncomeDao!!, it) }
        val taskViewModelFactory = repo?.let { TaskViewModelFactory(it) }

        viewModel = ViewModelProviders.of(this, taskViewModelFactory).get(TaskViewModel::class.java)

        var income = 0.0
        var expense = 0.0

        viewModel.getSumExpense().observe(viewLifecycleOwner, Observer {
            if (it == null) {
                expenseId.text = "0.0"
                expense = 0.0
                if (income == 0.0) totalId.text = "0.0"
                else totalId.text = income.toString()
            } else {
                expenseId.text = "-$it"
                expense = it

                totalId.text = (income - expense).toString()
            }
            when {
                (income - expense) > 0 -> {
                    totalId.setTextColor(Color.parseColor("#008000"))
                }
                (income - expense) < 0 -> {
                    totalId.setTextColor(Color.parseColor("#FF0000"))
                }
                else -> {
                    totalId.setTextColor(Color.parseColor("#FF000000"))
                }
            }
        })

        viewModel.getSumIncome().observe(viewLifecycleOwner, Observer {
            if (it == null) {
                incomeId.text = "0.0"
                income = 0.0
                if (expense == 0.0) totalId.text = "0.0"
                else totalId.text = expense.toString()
            } else {
                incomeId.text = it.toString()
                income = it


                totalId.text = (income - expense).toString()

            }
            when {
                (income - expense) > 0 -> {
                    totalId.setTextColor(Color.parseColor("#008000"))
                }
                (income - expense) < 0 -> {
                    totalId.setTextColor(Color.parseColor("#FF0000"))
                }
                else -> {
                    totalId.setTextColor(Color.parseColor("#FF000000"))
                }
            }
        })
    }
}