package com.example.roomdatabasemoneymanagerapp.RoomDataBase

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsqlitemoneymanagerappassignment.recyclerViewClass.OnExpenseClickListener
import com.example.androidsqlitemoneymanagerappassignment.recyclerViewClass.OnIncomeClickListener
import kotlinx.android.synthetic.main.item_layout.view.*

class IncomeViewHolder(itemView: View, var onClickListener: OnIncomeClickListener) : RecyclerView.ViewHolder(itemView) {
    fun setIncomeData(incomeTable: IncomeTable){
        itemView?.apply {
            Amount.setTextColor(Color.parseColor("#008000"))
            Amount.text = "+₹ ${incomeTable.amount}"
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
            Amount.setTextColor(Color.parseColor("#FF0000"))
            Amount.text = "-₹ ${expenseTable.amount}"

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