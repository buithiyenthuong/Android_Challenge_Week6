package com.Android_w6.nhom14.challenge_w6.Activity.Movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.Android_w6.nhom14.challenge_w6.Activity.Movie.Fragment.TopMovieFragment
import com.Android_w6.nhom14.challenge_w6.Activity.Movie.Fragment.PlayingMovieFragment
import com.Android_w6.nhom14.challenge_w6.R
import com.Android_w6.nhom14.challenge_w6.databinding.ActivityRestaurantBinding

class ListMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestaurantBinding
    private lateinit var viewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            if (!viewModel.times) {
                add<PlayingMovieFragment>(R.id.fragment_mainapp)
                addToBackStack(null)
            }
        }
        viewModel.times=true
        BindingOnchangeOption()
    }
    private fun BindingOnchangeOption() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            supportFragmentManager.commit {
                setReorderingAllowed(true)

                when (item.itemId) {
                    R.id.general -> {
                        replace<PlayingMovieFragment>(R.id.fragment_mainapp)
                    }
                    R.id.favorite -> {
                        replace<TopMovieFragment>(R.id.fragment_mainapp)
                    }
                }
                addToBackStack(null)
            }
            return@OnNavigationItemSelectedListener true
        })
    }
}