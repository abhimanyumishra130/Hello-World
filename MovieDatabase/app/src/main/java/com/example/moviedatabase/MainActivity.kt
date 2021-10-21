package com.example.moviedatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedatabase.MVVM.ItemViewModel
import com.example.moviedatabase.databinding.ActivityMainBinding
import com.example.moviedatabase.recyclerView.ItemAdapter
import com.example.moviedatabase.remote.ApiClient
import com.example.moviedatabase.remote.Network
import com.example.moviedatabase.remote.ResponseModel
import com.example.moviedatabase.remote.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemViewModel: ItemViewModel
    lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        setAdapter()
        itemViewModel.getAllData().observe(this, Observer {
            it?.let {
                CoroutineScope(Dispatchers.IO).launch {
                    itemAdapter.submitData(it)
                }
            }
        })






    }
    

    fun setAdapter(){
        itemAdapter = ItemAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        binding.apply {
            recyclerView.adapter = itemAdapter
            recyclerView.layoutManager = linearLayoutManager
        }
    }
}