package com.Android_w6.nhom14.challenge_w6.Activity.MovieData

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Android_w6.nhom14.challenge_w6.Model.Movie
import com.Android_w6.nhom14.challenge_w6.rest.RestClient
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    fun getNowplaying()
    {
        var tpm : List<Movie> = listOf()
        viewModelScope.launch{
            val movieRest = RestClient.getInstance().API.listNowPlayMovies(language = "en-US",page = 1)
            Log.e("NowPlaying",movieRest.results.toString())
            tpm=movieRest.results
        }
        Log.e("GlobalLSTPM",tpm.toString())
    }
    fun getToprated()
    {
        viewModelScope.launch {
            val toprateRest = RestClient.getInstance().API.listTopRated(language = "en-US",page = 1)
            Log.e("TopRated",toprateRest.results.toString())
        }
    }
    fun getNowplaying2() : List<Movie>
    {
            var tmp : List<Movie> = listOf()
            viewModelScope.launch{
                val movieRest = RestClient.getInstance().API.listNowPlayMovies(language = "en-US",page = 1)
                tmp=movieRest.results.toList()
                Log.e("localplaying",tmp.toString())
            }
            Log.e("globalplaying",tmp.toString())
            return tmp
    }

}