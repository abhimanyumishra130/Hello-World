package com.example.androidmemesappusingmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmemesappusingmvvm.databinding.ActivityMainBinding
import com.example.androidmemesappusingmvvm.recyclerView.AdapterItem
import com.example.androidmemesappusingmvvm.recyclerView.model.Meme
import com.example.androidmemesappusingmvvm.viewModel.ViewModelItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var itemViewModel:ViewModelItem

    private lateinit var adapter:AdapterItem
    private var list = arrayListOf<Meme>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemViewModel = ViewModelProvider(this).get(ViewModelItem::class.java)
        setReccyclerData()
        itemViewModel.getData().observe(this, Observer {
            it?.let {
                CoroutineScope(Dispatchers.IO).launch {
                    adapter.submitData(it)
                }
            }
        })


    }

    private fun setReccyclerData() {
        adapter = AdapterItem()
        binding.recyclerView.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager
    }
}