package com.Android_w6.nhom14.challenge_w6.Activity.Movie.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.Android_w6.nhom14.challenge_w6.Activity.Movie.DetailMovieActivity
import com.Android_w6.nhom14.challenge_w6.Activity.Movie.MovieRcvAdapter
import com.Android_w6.nhom14.challenge_w6.Activity.Movie.MovieViewModel
import com.Android_w6.nhom14.challenge_w6.Model.Movie
import com.Android_w6.nhom14.challenge_w6.OnItemClickListener
import com.Android_w6.nhom14.challenge_w6.R
import com.Android_w6.nhom14.challenge_w6.databinding.ListRestaurantBinding

class TopMovieFragment : Fragment(), OnItemClickListener {
    private lateinit var viewDataBinding: ListRestaurantBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var rcvAdapter: MovieRcvAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewDataBinding = DataBindingUtil.inflate<ListRestaurantBinding>(
            inflater,
            R.layout.list_restaurant,
            container,
            false
        )
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!viewModel.optionTypeView) {
            ChangLayouManager(R.layout.restaurant_item_view)
        } else {
            ChangLayouManager(R.layout.restaurant_item_cardview)
        }
        onChangeViewType()
    }

    fun onChangeViewType() {
        viewDataBinding.spinnerViewtype.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    when (position) {
                        0 -> {
                            ChangLayouManager(R.layout.restaurant_item_view)
                        }
                        1 -> {
                            ChangLayouManager(R.layout.restaurant_item_cardview)
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
    }

    fun ChangLayouManager(itemview: Int) {
        when (itemview) {
            R.layout.restaurant_item_view -> {
                rcvAdapter = MovieRcvAdapter(
                    R.layout.restaurant_item_view,
                    requireContext(),
                    this
                )
                viewDataBinding.rcList.layoutManager = LinearLayoutManager(context)
                viewModel.optionTypeView = true
            }

            R.layout.restaurant_item_cardview -> {
                rcvAdapter = MovieRcvAdapter(
                    R.layout.restaurant_item_cardview,
                    requireContext(),
                    this
                )
                viewDataBinding.rcList.layoutManager = GridLayoutManager(requireContext(), 2)
                viewModel.optionTypeView = false
            }
        }
        viewDataBinding.rcList.adapter = rcvAdapter
        viewModel.getToprated().observe(viewLifecycleOwner, Observer { result ->
            rcvAdapter.data = result
        })
    }

    override fun onItemClick(movie: Movie) {
        val intent = Intent(context, DetailMovieActivity::class.java)
        val bundle = Bundle()
        bundle.putString("KEY_VIEW", movie.popularity.toString())
        bundle.putString("KEY_TITLE", movie.originalTitle.toString())
        bundle.putString("KEY_RATE", movie.voteAverage.toString())
        bundle.putString("KEY_POSTER", movie.posterPath.toString())
        bundle.putString("KEY_OVERVIEW", movie.overview.toString())
        intent.putExtras(bundle)
        startActivity(intent)
    }
}