package com.example.moviedatabase.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedatabase.viewModel.ItemViewModel
import com.example.moviedatabase.databinding.ActivityMainBinding
import com.example.moviedatabase.data.recyclerView.Item2Adapter
import com.example.moviedatabase.data.recyclerView.ItemAdapter
import com.example.moviedatabase.data.recyclerView.OnClickListener
import com.example.moviedatabase.data.remote.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemViewModel: ItemViewModel
    lateinit var itemAdapter: ItemAdapter
    lateinit var item2Adapter:Item2Adapter

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
                    item2Adapter.submitData(it)
                }
            }
        })

        itemViewModel.getAllData().observe(this, Observer {
            it?.let {
                CoroutineScope(Dispatchers.IO).launch {
                    itemAdapter.submitData(it)
                }
            }
        })
    }
    

    fun setAdapter(){
        itemAdapter = ItemAdapter(this)
        item2Adapter = Item2Adapter(this)
        val gridLayoutManager = GridLayoutManager(this,3)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.apply {
            movieRecyclerView.adapter = itemAdapter
            movieRecyclerView.layoutManager = gridLayoutManager

            movieUpRecyclerView.adapter = item2Adapter
            movieUpRecyclerView.layoutManager = linearLayoutManager
        }
    }

    override fun onItemClicked(result: Result) {
        val intent = Intent(this@MainActivity, MovieDetailsActvity::class.java)
        intent.putExtra("result",result)
        startActivity(intent)
    }
}