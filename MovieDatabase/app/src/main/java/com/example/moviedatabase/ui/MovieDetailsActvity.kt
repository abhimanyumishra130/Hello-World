package com.example.moviedatabase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.moviedatabase.R
import com.example.moviedatabase.data.remote.Result
import com.example.moviedatabase.databinding.ActivityMovieDetailsActvityBinding

class MovieDetailsActvity : AppCompatActivity() {

    private lateinit var binding  : ActivityMovieDetailsActvityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsActvityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getSerializableExtra("result") as Result

        Glide.with(binding.imageView).load("https://image.tmdb.org/t/p/w500/"+result.backdrop_path).into(binding.imageView)
        binding.result = result

    }
}