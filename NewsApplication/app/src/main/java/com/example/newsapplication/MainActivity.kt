package com.example.newsapplication

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Adapter
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapplication.data.models.Article
import com.example.newsapplication.databinding.ActivityMainBinding
import com.example.newsapplication.ui.SecondActivity
import com.example.newsapplication.ui.adapterAndViewHolder.NewsAdapter
import com.example.newsapplication.ui.clickListener.NewsClickListener
import com.example.newsapplication.viewModel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NewsClickListener {

    private lateinit var adapter:NewsAdapter
    private var list = arrayListOf<Article>()
    private val viewModel:NewsViewModel by viewModels()

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if(checkForInternet(this)){
            viewModel.deleteNews()
            viewModel.saveAllNews()

            viewModel.getAllNews().observe(this, Observer {
                list.clear()
                list.addAll(it)
                adapter.notifyDataSetChanged()
            })

            adapter = NewsAdapter(list,this)
            val linearLayoutManager = LinearLayoutManager(this)
            binding.apply {
                rcRecyclerView.adapter = adapter
                rcRecyclerView.layoutManager = linearLayoutManager
            }
        }else{
            viewModel.getAllNews().observe(this, Observer {
                list.clear()
                list.addAll(it)
                adapter.notifyDataSetChanged()
            })

            adapter = NewsAdapter(list,this)
            val linearLayoutManager = LinearLayoutManager(this)
            binding.apply {
                rcRecyclerView.adapter = adapter
                rcRecyclerView.layoutManager = linearLayoutManager
            }
        }


    }

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

    override fun itemClicked(article: Article) {
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("article", article)
        startActivity(intent)
    }

}