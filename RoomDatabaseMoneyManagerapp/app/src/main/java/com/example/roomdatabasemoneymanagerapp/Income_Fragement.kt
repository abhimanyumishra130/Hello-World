package com.example.roomdatabasemoneymanagerapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidsqlitemoneymanagerappassignment.recyclerViewClass.OnIncomeClickListener
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.IncomeAdapter
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.IncomeTable
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.RoomDataBase
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val roomDatabase = context?.let { RoomDataBase.getDatabaseObject(it) }
        val taskIncomeDao = roomDatabase?.getIncomeDao()


        if (taskIncomeDao != null) {
            taskIncomeDao.getData().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                list.clear()
                list.addAll(it)
                moneyAdapter.notifyDataSetChanged()
            })
        }

        val sdf = SimpleDateFormat("  yyyy-MM-dd")
        val currentDate = sdf.format(Date())
        dateAddMain.text = currentDate

        moneyAdapter = IncomeAdapter(list, this)
        IncomeRecyclerView.adapter = moneyAdapter
        IncomeRecyclerView.layoutManager = LinearLayoutManager(context)
//        updateUI()

        dateAddMain.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            var dayy = calendar.get(Calendar.DAY_OF_MONTH)
            var month = calendar.get(Calendar.MONTH)
            var year = calendar.get(Calendar.YEAR)
            val datePickerDialog =
                context?.let { it1 -> DatePickerDialog(it1, this, year, month, dayy) }
            if (datePickerDialog != null) {
                datePickerDialog.show()
            }
        }


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

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        dateAddMain.text = "  $year-${month + 1}-$dayOfMonth"
    }

    override fun onIncomeEditClicked(moneyModel: IncomeTable, position: Int) {
        Toast.makeText(context, "rohit maar khayega", Toast.LENGTH_SHORT).show()
        mainEditLayout.visibility = View.VISIBLE

        submitCancelIncome.setOnClickListener {
            mainEditLayout.visibility = View.INVISIBLE
        }
        submitAddIncome.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val roomDatabase = context?.let { RoomDataBase.getDatabaseObject(it) }
                val taskIncomeDao = roomDatabase?.getIncomeDao()
                moneyModel.amount = amountAddMain.text.toString().toDouble()
                moneyModel.desc = descriptionAddMain.text.toString()
                moneyModel.date = dateAddMain.text.toString()
                taskIncomeDao?.updateData(moneyModel)
            }
            mainEditLayout.visibility = View.INVISIBLE
        }

    }

    override fun onIncomeDeleteClicked(moneyModel: IncomeTable, position: Int) {
        Toast.makeText(context, "rohit maar khayega", Toast.LENGTH_SHORT).show()
        val roomDatabase = context?.let { RoomDataBase.getDatabaseObject(it) }
        val taskIncomeDao = roomDatabase?.getIncomeDao()
        CoroutineScope(Dispatchers.IO).launch {
            taskIncomeDao?.deleteData(moneyModel)
        }

    }

}