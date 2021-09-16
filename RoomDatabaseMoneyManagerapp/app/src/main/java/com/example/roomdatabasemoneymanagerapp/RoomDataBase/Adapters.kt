package com.example.roomdatabasemoneymanagerapp.RoomDataBase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsqlitemoneymanagerappassignment.recyclerViewClass.OnExpenseClickListener
import com.example.androidsqlitemoneymanagerappassignment.recyclerViewClass.OnIncomeClickListener
import com.example.roomdatabasemoneymanagerapp.R

class IncomeAdapter(var list: MutableList<IncomeTable>,var onClickListener: OnIncomeClickListener)
    : RecyclerView.Adapter<IncomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomeViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return IncomeViewHolder(view,onClickListener)
    }

    override fun onBindViewHolder(holder: IncomeViewHolder, position: Int) {
        val moneyModel = list[position]
        holder.setIncomeData(moneyModel)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

}

class ExpenseAdapter(var list: MutableList<ExpenseTable>,var onClickListener: OnExpenseClickListener)
    : RecyclerView.Adapter<ExpenseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ExpenseViewHolder(view,onClickListener)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val moneyModel = list[position]
        holder.setExpenseData(moneyModel)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}