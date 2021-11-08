package com.example.w45_codingevalutation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.w45_codingevalutation.Data.Local.ArticleDatabase
import com.example.w45_codingevalutation.Data.Local.RoomDao
import com.example.w45_codingevalutation.Data.Local.RoomDataBase
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

        val db = RoomDataBase.getObject(applicationContext)
        val dao = db.getDao()

        val api = Network.getInstance().create(ApiClient::class.java)
        api.getData().enqueue(object :Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if(response.body()?.articles!=null){
                    list.clear()
                    list.addAll(response.body()!!.articles)
                    setRecyclerView()
                    adapter.notifyDataSetChanged()


                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        searchButton.setOnClickListener {
            searchItemBy()
        }

        sortData.setOnClickListener {
            sortDataBy()
        }



    }

    private fun sortDataBy() {
        val api3 = Network.getInstance().create(ApiClient::class.java)
        api3.getSortedData().enqueue(object :Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if(response.body()?.articles!=null){
                    list.clear()
                    list.addAll(response.body()!!.articles)
                    setRecyclerView()
                    adapter.notifyDataSetChanged()


                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun searchItemBy() {
        val api2 = Network.getInstance().create(ApiClient::class.java)

        var str = searchItem.text.toString()
        api2.getViaSearchData(str).enqueue(object :Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if(response.body()?.articles!=null){
                    list.clear()
                    list.addAll(response.body()!!.articles)
                    setRecyclerView()
                    adapter.notifyDataSetChanged()


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
        val db = RoomDataBase.getObject(applicationContext)
        val dao = db.getDao()
//        suspend {
//            article.let {
//                val articleDatabase = ArticleDatabase(it.author,it.content,it.description,it.publishedAt,it.title,it.urlToImage.toString())
//                dao.insert(articleDatabase)
//            }
//        }

        val intent = Intent(this,ArticleDetails::class.java)
        val bundle = Bundle()
        bundle.putString("title",article.title)
        bundle.putString("content",article.content)
        bundle.putString("desc",article.description)
        bundle.putString("date",article.publishedAt)
        bundle.putString("image",article.urlToImage.toString())
        intent.putExtra("bundle",bundle)
        startActivity(intent)
    }
}