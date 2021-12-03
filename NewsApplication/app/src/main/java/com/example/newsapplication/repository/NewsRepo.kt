package com.example.newsapplication.repository

import androidx.lifecycle.LiveData
import com.example.newsapplication.data.models.Article
import com.example.newsapplication.data.roomDatabase.NewsDao
import com.example.newsapplication.di.NewsModule
import com.example.newsapplication.utils.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsRepo @Inject constructor(val dao: NewsDao) {

    val api = NewsModule.getInstance().create(ApiService::class.java)

    fun saveAllNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = api.getApiData()
//            saveToDB(response.articles)
            dao.insertData(response.articles)
        }
    }

   fun getAllNews():LiveData<List<Article>>{
       return dao.getAllNews()
   }

    fun deleteAllNews(){
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAll()
        }
    }
}