package com.comet.moviesapp.ui.movies

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.comet.moviesapp.data.model.Movie
import com.comet.moviesapp.databinding.MoviesListItemBinding
import com.comet.moviesapp.utils.Constant

class MoviesAdapter(private val listener: MoviesItemListener) : RecyclerView.Adapter<MoviesViewHolder>() {

    interface MoviesItemListener {
        fun onItemClick(characterId: Long?, imageView: View)
    }

    private val items = ArrayList<Movie>()

    fun setItems(items: ArrayList<Movie>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding: MoviesListItemBinding = MoviesListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) = holder.bind(items[position])
}

class MoviesViewHolder(private val itemBinding: MoviesListItemBinding, private val listener: MoviesAdapter.MoviesItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var movie: Movie

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Movie) {
        this.movie = item
        itemBinding.textView.text = item.title
        itemBinding.tVTime.text = item.release_date
        itemBinding.tVAuthor.text = item.vote_average.toString()
        Glide.with(itemBinding.root)
            .load(Constant.IMAGE_BASE+item.backdrop_path)
            .centerCrop()
            .into(itemBinding.imageView)
    }

    override fun onClick(v: View) {
        listener.onItemClick(movie.id,v)
    }
}

