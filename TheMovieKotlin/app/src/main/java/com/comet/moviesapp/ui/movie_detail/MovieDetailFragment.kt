package com.comet.moviesapp.ui.movie_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.comet.moviesapp.data.model.Movie
import com.comet.moviesapp.databinding.FragmentMovieDetailBinding
import com.comet.moviesapp.utils.Constant
import com.comet.moviesapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding
    private val viewModel: MovieDetailViewModel by viewModels()
    private lateinit var movieId:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        print("movie id = ${arguments?.getString("movieId").toString()}")
        movieId = arguments?.getString("movieId").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.getMovieDetail(movieId).observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    initViews(it)
                    print(it.data)
                    print(it.data?.genres)
                }
                Resource.Status.ERROR -> {
                }
            }
        })
    }

    private fun initViews(resource: Resource<Movie>) {
        binding.movie = resource.data
        viewModel.setMovieImage(binding.imageView, Constant.IMAGE_BASE + resource.data?.backdrop_path)
    }
}