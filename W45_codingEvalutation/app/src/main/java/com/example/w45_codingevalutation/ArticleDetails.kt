package com.example.w45_codingevalutation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_article_details.*

class ArticleDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)

        intent.getBundleExtra("bundle").let {
            Glide.with(imageDetails).load(it?.getString("image")).into(imageDetails)
            titleDetails.text = it?.getString("title")
            descDetails.text = it?.getString("desc")
            contentDetails.text = it?.getString("content")
            dateDetails.text = it?.getString("date")
        }
    }
}