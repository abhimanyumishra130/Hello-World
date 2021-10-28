package com.example.roomdatabasemoneymanagerapp.Fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidsqlitemoneymanagerappassignment.recyclerViewClass.OnIncomeClickListener
import com.example.roomdatabasemoneymanagerapp.MVVM.Repository.MoneyRepo
import com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell.TaskViewModel
import com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell.TaskViewModelFactory
import com.example.roomdatabasemoneymanagerapp.R
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.IncomeAdapter
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.IncomeTable
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.RoomDataBase
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.TaskIncomeDao
import kotlinx.android.synthetic.main.edit_details.view.*
import kotlinx.android.synthetic.main.fragment_income__fragement.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class Income_Fragement : Fragment(R.layout.fragment_income__fragement),
    OnIncomeClickListener,
    DatePickerDialog.OnDateSetListener {


    private var list = mutableListOf<IncomeTable>()
    private lateinit var moneyAdapter: IncomeAdapter
    lateinit var viewModel: TaskViewModel


    //lateinit var taskIncomeDao: TaskIncomeDao


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val roomDatabase = context?.let { RoomDataBase.getDatabaseObject(it) }
        val taskIncomeDao = roomDatabase?.getIncomeDao()
        val taskExpenseDao = roomDatabase?.getExpenseDao()
        val repo = taskExpenseDao?.let { MoneyRepo(taskIncomeDao!!, it) }

        val viewModelFactory = repo?.let { TaskViewModelFactory(it) }

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(TaskViewModel::class.java)


//        if (taskIncomeDao != null) {
//            taskIncomeDao.getData().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
//                list.clear()
//                list.addAll(it)
//                moneyAdapter.notifyDataSetChanged()
//            })
//        }

        viewModel.getAllIncome().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                list.clear()
                list.addAll(it)
                moneyAdapter.notifyDataSetChanged()
        })

        moneyAdapter = IncomeAdapter(list, this)
        IncomeRecyclerView.adapter = moneyAdapter
        IncomeRecyclerView.layoutManager = LinearLayoutManager(context)

//        updateUI()




    }


//    override fun onIncomeEditClicked(moneyModel: MoneyModel, position: Int) {
//        Toast.makeText(context,"rohit maar khayega",Toast.LENGTH_SHORT).show()
//        mainEditLayout.visibility = View.VISIBLE
//        val liveData = LIveData()
//
//        submitCancelIncome.setOnClickListener {
//            mainEditLayout.visibility = View.INVISIBLE
//        }
//        submitAddIncome.setOnClickListener {
//            //val moneyModel = MoneyModel()
//            val dbHelper = DatabaseHelper(context)
//            moneyModel.amount = amountAddMain.text.toString().toDouble()
//            moneyModel.desc = descriptionAddMain.text.toString()
//            moneyModel.date = dateAddMain.text.toString()
//
//            dbHelper.editIncomeTask(moneyModel)
//
//            mainEditLayout.visibility = View.INVISIBLE
//            liveData.getIncomeData(dbHelper.getIncomeBalance())
//            liveData.getExpenseData(dbHelper.getExpenseBalance())
//            liveData.getTotalData(dbHelper.getIncomeBalance()-dbHelper.getExpenseBalance())
//            updateUI()
//        }
//    }

//    override fun onDeleteClicked(moneyModel: MoneyModel, position: Int) {
//        val dbHelper = DatabaseHelper(context)
//        val liveData = LIveData()
//        dbHelper.deleteFromIncome(moneyModel)
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
//        list.addAll(dbHelper.getAllIncome())
//        moneyAdapter.notifyDataSetChanged()
//    }

    override fun onDateSet(vieww: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
//        dateAddMain?.text = "  $year-${month + 1}-$dayOfMonth"
    }

    override fun onIncomeEditClicked(moneyModel: IncomeTable, position: Int) {
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

//        view?.dateAddMain?.text = sdf.format(calendar.time)
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
            viewModel.updateIncome(moneyModel)
            alertDialog.cancel()
//            mainEditLayout.visibility = View.INVISIBLE
        }

    }

    override fun onIncomeDeleteClicked(moneyModel: IncomeTable, position: Int) {
        Toast.makeText(context, "rohit maar khayega", Toast.LENGTH_SHORT).show()
        val roomDatabase = context?.let { RoomDataBase.getDatabaseObject(it) }
        val taskIncomeDao = roomDatabase?.getIncomeDao()
//        CoroutineScope(Dispatchers.IO).launch {
//            taskIncomeDao?.deleteData(moneyModel)
//        }
        viewModel.deleteIncome(moneyModel)

    }

}