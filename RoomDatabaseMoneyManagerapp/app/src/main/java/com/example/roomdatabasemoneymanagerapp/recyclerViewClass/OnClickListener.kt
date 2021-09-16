package com.example.androidsqlitemoneymanagerappassignment.recyclerViewClass

import com.example.roomdatabasemoneymanagerapp.RoomDataBase.ExpenseTable
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.IncomeTable

interface OnIncomeClickListener {
    fun onIncomeEditClicked(moneyModel: IncomeTable,position: Int)
    fun onIncomeDeleteClicked(moneyModel: IncomeTable,position: Int)
}

interface OnExpenseClickListener{
    fun onExpenseEditClicked(moneyModel: ExpenseTable,position: Int)
    fun onExpenseDeleteClicked(moneyModel: ExpenseTable,position: Int)
}