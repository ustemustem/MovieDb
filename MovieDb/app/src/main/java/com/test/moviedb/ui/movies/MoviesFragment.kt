package com.test.moviedb.ui.movies

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import com.test.moviedb.R


class MoviesFragment : Fragment() {


    private lateinit var homeViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(MovieViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_movies, container, false)
        // val textView: TextView = root.findViewById(R.id.fragment_movies)
        homeViewModel.text.observe(this, Observer {
        })

        val activity = activity as Context
        val moviesrecyclerView1 = root?.findViewById<RecyclerView>(R.id.recyclerView_movies)
        val nowplayingrecyclerView2 = root?.findViewById<RecyclerView>(R.id.recyclerView_nowPlaying)
        val popularrecyclerView3 = root?.findViewById<RecyclerView>(R.id.recyclerView_popular)
        //toprated
        val layout1 = LinearLayoutManager(activity)
        layout1.orientation = HORIZONTAL
        moviesrecyclerView1?.layoutManager = layout1
        moviesrecyclerView1?.adapter = trmAdapter()
        //nowplaying
        val layout2 = LinearLayoutManager(activity)
        layout2.orientation = HORIZONTAL
        nowplayingrecyclerView2?.layoutManager = layout2
        nowplayingrecyclerView2?.adapter = npmAdapter()
        //popular
        val layout3 = LinearLayoutManager(activity)
        layout3.orientation = HORIZONTAL
        popularrecyclerView3?.layoutManager = layout3
        popularrecyclerView3?.adapter = pmAdapter()


        return root
    }
}