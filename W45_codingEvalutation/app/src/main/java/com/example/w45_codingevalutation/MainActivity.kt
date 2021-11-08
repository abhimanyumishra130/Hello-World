package com.example.w45_codingevalutation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.w45_codingevalutation.Data.remote.ApiClient
import com.example.w45_codingevalutation.Data.remote.Article
import com.example.w45_codingevalutation.Data.remote.Network
import com.example.w45_codingevalutation.Data.remote.ResponseModel
import com.example.w45_codingevalutation.View.RecyclerView.ItemAdapter
import com.example.w45_codingevalutation.View.RecyclerView.ItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), ItemClickListener {

    private var list = arrayListOf<Article>()
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = Network.getInstance().create(ApiClient::class.java)
        api.getData().enqueue(object :Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if(response.body()?.articles!=null){
                    list.addAll(response.body()!!.articles)
                    setRecyclerView()
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun setRecyclerView() {
        adapter = ItemAdapter(list,this)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    override fun onItemClicked(article: Article) {

    }
}