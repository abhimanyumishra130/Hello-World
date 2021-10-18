package com.example.unit_5sprint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unit_5sprint1.recyclerView.ItemAdapter
import com.example.unit_5sprint1.retrofit.ApiClient
import com.example.unit_5sprint1.retrofit.Network
import com.example.unit_5sprint1.retrofit.ResponseModel
import com.example.unit_5sprint1.retrofit.ResponseModelItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var list = arrayListOf<ResponseModelItem>()
    lateinit var itemAdapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buildListData()

    }

    private fun buildListData() {
        val api = Network.getRetrofit().create(ApiClient::class.java)
//        CoroutineScope(Dispatchers.IO).launch {
//            list.addAll(api.getApiData())
//        }
        api.getApiData(1).enqueue(object :Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if(response.body()!=null){
                    list.addAll(response.body()!!)
                    setRecyclerView()
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

            }

        })


    }

    private fun setRecyclerView() {
        itemAdapter = ItemAdapter(list)
        var linearLayoutManager = LinearLayoutManager(this)

        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = linearLayoutManager
    }
}