package com.example.unit_5sprint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unit_5sprint1.MVVM.Repository
import com.example.unit_5sprint1.MVVM.ViewModelFactory
import com.example.unit_5sprint1.MVVM.ViewModell
import com.example.unit_5sprint1.RoomDatabase.ActorRoomDataBase
import com.example.unit_5sprint1.RoomDatabase.ItemDao
import com.example.unit_5sprint1.RoomDatabase.Model
import com.example.unit_5sprint1.recyclerView.ItemAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var list = arrayListOf<Model>()
    lateinit var itemAdapter: ItemAdapter

    lateinit var roomDataBase: ActorRoomDataBase
    lateinit var itemDao: ItemDao
    lateinit var viewModel: ViewModell

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roomDataBase = ActorRoomDataBase.databaseObject(this)
        itemDao = roomDataBase.getDao()

        val repository = Repository(itemDao)
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ViewModell::class.java)

//        viewModel.insertData()
        viewModel.getAllData().observe(this, Observer {
            list.addAll(it)
        })
//        var viewModel =  ViewModel(Repository())
//        list.addAll(viewModel.getAllData())
        setRecyclerView()
//        buildListData()



    }

//    private fun buildListData() {
//        val api = Network.getRetrofit().create(ApiClient::class.java)
////        CoroutineScope(Dispatchers.IO).launch {
////            list.addAll(api.getApiData())
////        }
//        api.getApiData(1).enqueue(object :Callback<ResponseModel>{
//            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
//                if(response.body()!=null){
//                    list.addAll(response.body()!!)
//                    setRecyclerView()
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
//
//            }
//
//        })
//
//
//    }

    private fun setRecyclerView() {
        itemAdapter = ItemAdapter(list)
        var linearLayoutManager = LinearLayoutManager(this)

        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = linearLayoutManager
    }
}