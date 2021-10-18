package com.example.roomdatabasemoneymanagerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.roomdatabasemoneymanagerapp.MVVM.Repository.MoneyRepo
import com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell.TaskViewModel
import com.example.roomdatabasemoneymanagerapp.MVVM.ViewModell.TaskViewModelFactory
import com.example.roomdatabasemoneymanagerapp.Retrofit.Status
import com.example.roomdatabasemoneymanagerapp.Retrofit.requests.LoginRequestModel
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.RoomDataBase
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.TaskExpenseDao
import com.example.roomdatabasemoneymanagerapp.RoomDataBase.TaskIncomeDao
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.jetbrains.anko.longToast

class SignInActivity : AppCompatActivity() {

    lateinit var roomDB:RoomDataBase
    lateinit var taskIncomeDao: TaskIncomeDao
    lateinit var taskExpenseDao: TaskExpenseDao
    lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        roomDB = RoomDataBase.getDatabaseObject(this)
        taskIncomeDao = roomDB.getIncomeDao()
        taskExpenseDao = roomDB.getExpenseDao()
        val repo = MoneyRepo(taskIncomeDao,taskExpenseDao)

        val taskViewModelFactory = TaskViewModelFactory(repo)
        taskViewModel = ViewModelProviders.of(this,taskViewModelFactory).get(TaskViewModel::class.java)


//        val loginRequestModel = LoginRequestModel( userName =
////            "pradeep1706108@gmail.com",password = "dhankhar")


        signInBtn.setOnClickListener {
           val loginRequestModel = LoginRequestModel(emailSignIn.text.toString(),passwordSignIn.text.toString())
//            val loginRequestModel = LoginRequestModel( userName =
//            "pradeep1706108@gmail.com",password = "dhankhar")
            taskViewModel.userLogin(loginRequestModel)
                .observe(this, Observer {

                    val response = it

                    when(response.status){
                        Status.SUCCESS->{
//                            val name = response.data?.user?.name!!
//                            val email = response.data?.user?.email!!
//                            longToast("$name and $email")
                            val intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        }
                        Status.ERROR->{
                            val error = response.message!!
                            longToast("Invalid email and password")
                        }
                        Status.LOADING->{

                        }
                    }
                })
        }

        registerInBtn.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}