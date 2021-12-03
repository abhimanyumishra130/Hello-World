package com.example.newsapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.newsapplication.R
import com.example.newsapplication.data.models.Article
import com.example.newsapplication.databinding.ActivitySecondBinding
import com.example.newsapplication.viewModel.NewsViewModel

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val article = intent.getSerializableExtra("article") as Article

//        binding.apply {
//            newsHeadline.text = article?.title
//            newsDate.text = article?.publishedAt
//            newsSite.text = article?.author
//            tvContentSecond.text = article?.content
//        }
        binding.article = article
        Glide.with(binding.newsImage).load(article?.urlToImage).into(binding.newsImage)
    }
}