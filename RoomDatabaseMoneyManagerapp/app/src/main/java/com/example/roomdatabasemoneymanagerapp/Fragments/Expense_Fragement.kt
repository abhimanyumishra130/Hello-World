package com.example.roomdatabasemoneymanagerapp.Fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidsqlitemoneymanagerappassignment.recyclerViewClass.OnExpenseClickListener
import com.example.roomdatabasemoneymanagerapp.MVVM.Repository.MoneyRepo
import com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell.TaskViewModel
import com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell.TaskViewModelFactory
import com.example.roomdatabasemoneymanagerapp.R
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.ExpenseAdapter
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.ExpenseTable
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.RoomDataBase
import kotlinx.android.synthetic.main.edit_details.view.*
import kotlinx.android.synthetic.main.fragment_expense__fragement.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class Expense_Fragement : Fragment(R.layout.fragment_expense__fragement),
    OnExpenseClickListener,
    DatePickerDialog.OnDateSetListener {


    companion object{
        private var list = mutableListOf<ExpenseTable>()
        private lateinit var  moneyAdapter: ExpenseAdapter
    }

    lateinit var viewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val roomDatabase = context?.let { RoomDataBase.getDatabaseObject(it) }
        val taskIncomeDao = roomDatabase?.getIncomeDao()
        val taskExpenseDao = roomDatabase?.getExpenseDao()
        val repo = taskExpenseDao?.let { MoneyRepo(taskIncomeDao!!, it) }

        val viewModelFactory = repo?.let { TaskViewModelFactory(it) }

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(TaskViewModel::class.java)

//        if (taskExpenseDao != null) {
//            taskExpenseDao.getData().observe(viewLifecycleOwner,
//                androidx.lifecycle.Observer {
//                    list.clear()
//                list.addAll(it)
//                    moneyAdapter.notifyDataSetChanged()
//            })
//        }

        viewModel.getAllExpense().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                list.clear()
                list.addAll(it)
                moneyAdapter.notifyDataSetChanged()
        })


        moneyAdapter = ExpenseAdapter(list,this)
        ExpenseRecyclerView.adapter = moneyAdapter
        ExpenseRecyclerView.layoutManager = LinearLayoutManager(context)







    }

//    override fun onEditClicked(moneyModel: MoneyModel, position: Int) {
//        Toast.makeText(context,"rohit maar khayega",Toast.LENGTH_SHORT).show()
//        expenseEditLayout.visibility = View.VISIBLE
//        val liveData = LIveData()
//
//        submitCancelExpense.setOnClickListener {
//            expenseEditLayout.visibility = View.INVISIBLE
//        }
//        submitAddExpense.setOnClickListener {
//            //val moneyModel = MoneyModel()
//            val dbHelper = DatabaseHelper(context)
//            moneyModel.amount = amountAddExpense.text.toString().toDouble()
//            moneyModel.desc = descriptionAddExpense.text.toString()
//            moneyModel.date = dateAddExpense.text.toString()
//
//            dbHelper.editExpenseTask(moneyModel)
//
//            expenseEditLayout.visibility = View.INVISIBLE
//            liveData.getIncomeData(dbHelper.getIncomeBalance())
//            liveData.getExpenseData(dbHelper.getExpenseBalance())
//            liveData.getTotalData(dbHelper.getIncomeBalance()-dbHelper.getExpenseBalance())
//            updateUI()
//        }
//    }

//    override fun onDeleteClicked(moneyModel: MoneyModel, position: Int) {
//        val dbHelper = DatabaseHelper(context)
//        val liveData = LIveData()
//        dbHelper.deleteFromExpense(moneyModel)
//        var income = dbHelper.getIncomeBalance()
//        var expense = dbHelper.getExpenseBalance()
//        var total = dbHelper.getIncomeBalance()-dbHelper.getExpenseBalance()
//
//        liveData.getIncomeData(income)
//        liveData.getExpenseData(expense)
//        liveData.getTotalData(total)
//        updateUI()
//    }


//    fun updateUI(){
//        val dbHelper = DatabaseHelper(context)
//        list.clear()
//        list.addAll(dbHelper.getAllExpense())
//        moneyAdapter.notifyDataSetChanged()
//    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

    }

    override fun onExpenseEditClicked(moneyModel: ExpenseTable, position: Int) {
        val view = layoutInflater.inflate(R.layout.edit_details,null)

        //set view to alert dialog
        val alertDialog = AlertDialog.Builder(context).create()
        alertDialog.setCancelable(false)
        alertDialog.setView(view)
        alertDialog.show()
//        view.mainEditLayout.visibility = View.VISIBLE
// date code
        val sdf = SimpleDateFormat("  yyyy-MM-dd")
        val currentDate = sdf.format(Date())
        view?.dateAddMain?.text = currentDate



        //date picker
        view.dateAddMain.setOnClickListener {
            val cal = Calendar.getInstance()

            val dateSetListener =
                DatePickerDialog.OnDateSetListener { anotherView, year, monthOfYear, dayOfMonth ->
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    val myFormat = "yyyy-MM-dd" // mention the format you need
                    val sdf = SimpleDateFormat(myFormat, Locale.US)
                    view.dateAddMain.text = sdf.format(cal.time)
                }

            DatePickerDialog(
                view.context,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()

        }

        view.submitCancelIncome.setOnClickListener {
            alertDialog.cancel()
        }

        view.submitAddIncome.setOnClickListener {

            val roomDatabase = context?.let { RoomDataBase.getDatabaseObject(it) }
            val taskIncomeDao = roomDatabase?.getIncomeDao()
            moneyModel.amount = view.amountAddMain.text.toString().toDouble()
            moneyModel.desc = view.descriptionAddMain.text.toString()
            moneyModel.date = view.dateAddMain.text.toString()
//            CoroutineScope(Dispatchers.IO).launch {
//                taskIncomeDao?.updateData(moneyModel)
//            }
            viewModel.updateExpense(moneyModel)
            alertDialog.cancel()
//            mainEditLayout.visibility = View.INVISIBLE
        }

    }

    override fun onExpenseDeleteClicked(moneyModel: ExpenseTable, position: Int) {
        Toast.makeText(context,"rohit maar khayega",Toast.LENGTH_SHORT).show()
        val roomDataBase = context?.let { RoomDataBase.getDatabaseObject(it) }
        val taskExpenseDao = roomDataBase?.getExpenseDao()
//        CoroutineScope(Dispatchers.IO).launch {
//            taskExpenseDao?.deleteData(moneyModel)
//        }
        viewModel.deleteExpense(moneyModel)
    }
}