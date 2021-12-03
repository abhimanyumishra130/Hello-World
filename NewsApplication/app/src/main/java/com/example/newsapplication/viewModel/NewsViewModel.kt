package com.example.newsapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.newsapplication.data.models.Article
import com.example.newsapplication.repository.NewsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(val repo: NewsRepo):ViewModel() {

    fun saveAllNews(){
        repo.saveAllNews()
    }

    fun getAllNews():LiveData<List<Article>>{
        return repo.getAllNews()
    }
    fun deleteNews(){
        repo.deleteAllNews()
    }
}