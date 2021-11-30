package com.example.androidshorttake_awayassignment_i

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.searchapi.data.Status
import com.example.androidshorttake_awayassignment_i.data.model.Address
import com.example.androidshorttake_awayassignment_i.databinding.ActivityMainBinding
import com.example.androidshorttake_awayassignment_i.repository.Repo
import com.example.androidshorttake_awayassignment_i.ui.Adapter.SearchAdapter
import com.example.androidshorttake_awayassignment_i.viewModel.SearchViewModel
import com.example.androidshorttake_awayassignment_i.viewModel.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: SearchAdapter
    private var list = emptyList<Address>()
   lateinit var  viewModel:SearchViewModel

//    val viewModel:SearchViewModel by viewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repo = Repo()

        val viewModelFactory = ViewModelFactory(repo)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)

        binding.etSearch.doAfterTextChanged {
            if(binding.etSearch.text.toString().length > 0){
                binding.tvWelcome.visibility = View.GONE
                binding.rcRecyclerView.visibility = View.VISIBLE
                loadData(binding.etSearch.text.toString())
            }else{
                binding.rcRecyclerView.visibility = View.GONE
                binding.tvWelcome.visibility = View.VISIBLE
            }

        }



    }

    fun loadData(string: String) {
        viewModel.getListAddress(string).observe(this, {
            when (it.status) {
                Status.ERROR -> {

                }
                Status.SUCCESS -> {

                    list = it.data?.data?.addressList!!
                    adapter = SearchAdapter(list)
                    val linearLayoutManager = LinearLayoutManager(this)
                    binding.apply {
                        rcRecyclerView.adapter = adapter
                        rcRecyclerView.layoutManager = linearLayoutManager
                    }
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }

}