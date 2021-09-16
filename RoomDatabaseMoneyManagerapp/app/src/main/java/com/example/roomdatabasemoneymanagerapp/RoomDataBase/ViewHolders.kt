package com.example.roomdatabasemoneymanagerapp.RoomDataBase

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsqlitemoneymanagerappassignment.recyclerViewClass.OnExpenseClickListener
import com.example.androidsqlitemoneymanagerappassignment.recyclerViewClass.OnIncomeClickListener
import kotlinx.android.synthetic.main.item_layout.view.*

class IncomeViewHolder(itemView: View, var onClickListener: OnIncomeClickListener) : RecyclerView.ViewHolder(itemView) {
    fun setIncomeData(incomeTable: IncomeTable){
        itemView?.apply {
            Amount.text = incomeTable.amount.toString()
            Description.text = incomeTable.desc
            Date.text = incomeTable.date

            editItem.setOnClickListener {
                onClickListener.onIncomeEditClicked(incomeTable,adapterPosition)
            }

            deleteItem.setOnClickListener {
                onClickListener.onIncomeDeleteClicked(incomeTable,adapterPosition)
            }
        }
    }
}

class ExpenseViewHolder(itemView: View, var onClickListener: OnExpenseClickListener) : RecyclerView.ViewHolder(itemView) {
    fun setExpenseData(expenseTable: ExpenseTable){
        itemView?.apply {
            Amount.text = expenseTable.amount.toString()
            Description.text = expenseTable.desc
            Date.text = expenseTable.date

            editItem.setOnClickListener {
                onClickListener.onExpenseEditClicked(expenseTable,adapterPosition)
            }

            deleteItem.setOnClickListener {
                onClickListener.onExpenseDeleteClicked(expenseTable,adapterPosition)
            }
        }
    }

}