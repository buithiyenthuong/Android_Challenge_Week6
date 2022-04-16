package com.Android_w6.nhom14.challenge_w6.Activity.Movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.Android_w6.nhom14.challenge_w6.R
import com.Android_w6.nhom14.challenge_w6.databinding.ActivityDetailBinding

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val intent = getIntent()
        val bundle = intent.getExtras()
        if(bundle != null) {
            val viewmovie= bundle.getString("KEY_VIEW")
            binding.movieLanguage.text = viewmovie

            val poster ="https://image.tmdb.org/t/p/w500" + bundle.getString("KEY_POSTER")
            Glide.with(this).load( poster).centerCrop().placeholder(R.drawable.loading_icon).into(binding.moviePoster)

            val title = bundle.getString("KEY_TITLE")
            binding.textView5.text = title

            val rate = bundle.getString("KEY_RATE")
            binding.movieRate.text = rate

            val overview = bundle.getString("KEY_OVERVIEW")
            binding.textView6.text = overview


        }

    }
}