package com.example.itunesapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.itunesapp.databinding.ActivityMainBinding
import com.example.itunesapp.ui.MusicAdapter
import com.example.itunesapp.viewModel.MusicViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.itunesapp.data.model.MusicTable


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private  var list = arrayListOf<MusicTable>()
    private lateinit var adapter:MusicAdapter

    private val viewModel:MusicViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(checkForInternet(this)){
            binding.btnSearch.setOnClickListener {
                val string = binding.etTerm.text.toString()
//            loadData(string)
//                CoroutineScope(Dispatchers.IO).launch {
//                }
                viewModel.deleteAll()
                viewModel.saveAllMusic(string)

                viewModel.getAllMusics().observe(this, Observer {
                    list.clear()
                    list.addAll(it)
                    adapter.notifyDataSetChanged()
                })

                adapter = MusicAdapter(list)
                val gridLayoutManager = GridLayoutManager(this,2)
                binding.apply {
                    rcRecyclerView.adapter = adapter
                    rcRecyclerView.layoutManager = gridLayoutManager
                }

            }
        }
        else{
            viewModel.getAllMusics().observe(this, Observer {
                list.clear()
                list.addAll(it)
                adapter.notifyDataSetChanged()
            })

            adapter = MusicAdapter(list)
            val gridLayoutManager = GridLayoutManager(this,2)
            binding.apply {
                rcRecyclerView.adapter = adapter
                rcRecyclerView.layoutManager = gridLayoutManager
            }

            binding.btnSearch.setOnClickListener {
                Toast.makeText(this,"Turn On the Internet",Toast.LENGTH_SHORT).show()
            }
        }


    }

//    fun loadData(string:String){
//        viewModel.getAllMusicFromApi(string).observe(this, Observer {
//            when(it.status){
//                Status.ERROR ->{
//                    Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show()
//                }
//                Status.LOADING -> {
//                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
//                }
//                Status.SUCCESS ->{
//                    list.addAll(it?.data?.results!!)
//                    adapter = MusicAdapter(list)
//                    val gridLayoutManager = GridLayoutManager(this,2)
//                    binding.apply {
//                        rcRecyclerView.adapter = adapter
//                        rcRecyclerView.layoutManager = gridLayoutManager
//                    }
//                    adapter.notifyDataSetChanged()
//                }
//            }
//        })
//    }

    private fun checkForInternet(context: Context): Boolean {

        // register activity with the connectivity manager service
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // if the android version is equal to M
        // or greater we need to use the
        // NetworkCapabilities to check what type of
        // network has the internet connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // Returns a Network object corresponding to
            // the currently active default data network.
            val network = connectivityManager.activeNetwork ?: return false

            // Representation of the capabilities of an active network.
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                // Indicates this network uses a Wi-Fi transport,
                // or WiFi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                // Indicates this network uses a Cellular transport. or
                // Cellular has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                // else return false
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }
}