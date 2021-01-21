package com.comet.moviesapp.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.comet.moviesapp.databinding.FragmentMovieListBinding
import com.example.rickandmorty.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListFragment : Fragment(), MoviesAdapter.MoviesItemListener {

    private lateinit var binding: FragmentMovieListBinding
    private val viewModel: MovieListViewModel by viewModels()
    private lateinit var adapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = MoviesAdapter(this)
        binding.plantList.layoutManager = LinearLayoutManager(requireContext())
        binding.plantList.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.result.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                else -> {

                }
            }
        })
    }

    override fun onItemClick(characterId: Long?) {
        TODO("Not yet implemented")
    }
}