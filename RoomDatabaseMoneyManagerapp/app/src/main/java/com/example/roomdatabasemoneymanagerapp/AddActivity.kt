package com.example.roomdatabasemoneymanagerapp

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.roomdatabasemoneymanagerapp.MVVM.Repository.MoneyRepo
import com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell.TaskViewModel
import com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell.TaskViewModelFactory
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.*
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class AddActivity : AppCompatActivity() , DatePickerDialog.OnDateSetListener{
    var dayy:Int = 0
    var month: Int = 0
    var year: Int = 0

//    val dbHandler = DatabaseHelper(this)

    lateinit var roomDataBase: RoomDataBase
    lateinit var taskIncomeDao: TaskIncomeDao
    lateinit var taskExpenseDao: TaskExpenseDao
    lateinit var viewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val sdf = SimpleDateFormat("  yyyy-MM-dd")
        val currentDate = sdf.format(Date())
        dateAdd.text = currentDate

        roomDataBase = RoomDataBase.getDatabaseObject(this)
        taskIncomeDao = roomDataBase.getIncomeDao()
        taskExpenseDao = roomDataBase.getExpenseDao()

        val repo = MoneyRepo(taskIncomeDao,taskExpenseDao)
        val taskViewModelFactory = TaskViewModelFactory(repo)
        viewModel = ViewModelProviders.of(this,taskViewModelFactory).get(TaskViewModel::class.java)


        onClick()
    }

    private fun onClick() {
        dateAdd.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            dayy = calendar.get(Calendar.DAY_OF_MONTH)
            month = calendar.get(Calendar.MONTH)
            year = calendar.get(Calendar.YEAR)
            val datePickerDialog =
                DatePickerDialog(this, this, year,month,dayy)
            datePickerDialog.show()
        }

        submitAdd.setOnClickListener {

            val tableName = SpinnerAdd.selectedItem.toString()
            val date = dateAdd.text.toString()
            val amount = amountAdd.text.toString().toDouble()
            val description = descriptionAdd.text.toString()
            val incomeTable = IncomeTable(amount,description,date)
            val expenseTable = ExpenseTable(amount,description,date)

            CoroutineScope(Dispatchers.IO).launch {
                when(tableName){
                    "Income" -> viewModel.insertIncome(incomeTable)
                    "Expense" -> viewModel.insertExpense(expenseTable)
                }
            }


            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext,"${SpinnerAdd.selectedItem.toString()}",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        dateAdd.text = "  $year-${month+1}-$dayOfMonth"
    }
}