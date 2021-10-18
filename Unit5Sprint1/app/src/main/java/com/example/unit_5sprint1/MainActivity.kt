package com.example.unit_5sprint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unit_5sprint1.MVVM.Repository
import com.example.unit_5sprint1.MVVM.ViewModel
import com.example.unit_5sprint1.RoomDatabase.ActorRoomDataBase
import com.example.unit_5sprint1.RoomDatabase.ItemDao
import com.example.unit_5sprint1.RoomDatabase.Model
import com.example.unit_5sprint1.recyclerView.ItemAdapter
import com.example.unit_5sprint1.retrofit.ApiClient
import com.example.unit_5sprint1.retrofit.Network
import com.example.unit_5sprint1.retrofit.ResponseModel
import com.example.unit_5sprint1.retrofit.ResponseModelItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var list = arrayListOf<Model>()
    lateinit var itemAdapter: ItemAdapter

    lateinit var roomDataBase: ActorRoomDataBase
    lateinit var itemDao: ItemDao
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roomDataBase = ActorRoomDataBase.databaseObject(this)
        itemDao = roomDataBase.getDao()

        val repository = Repository(itemDao)
        viewModel = ViewModel(repository)

        viewModel.insertData()
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