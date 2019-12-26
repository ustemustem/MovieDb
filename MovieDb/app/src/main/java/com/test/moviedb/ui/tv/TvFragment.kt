package com.test.moviedb.ui.tv

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.moviedb.R


class TvFragment : Fragment() {

    private lateinit var tvViewModel: TvViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tvViewModel =
            ViewModelProviders.of(this).get(TvViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tv, container, false)
      //  val textView: TextView = root.findViewById(R.id.fragment_tv)
        tvViewModel.text.observe(this, Observer {

        })
        val activity = activity as Context
        val tvrecyclerView1 = root?.findViewById<RecyclerView>(R.id.recyclerView_tv)
        val tvpopularrecyclerView2 = root?.findViewById<RecyclerView>(R.id.recyclerView_tv_popular)
       //tv
        val layout1 = LinearLayoutManager(activity)
        layout1.orientation = LinearLayoutManager.HORIZONTAL
        tvrecyclerView1?.layoutManager = layout1
        tvrecyclerView1?.adapter = tvAdapter()
       //popular
        val layout2 = LinearLayoutManager(activity)
        layout2.orientation = LinearLayoutManager.HORIZONTAL
        tvpopularrecyclerView2?.layoutManager = layout2
        tvpopularrecyclerView2?.adapter = ptvAdapter()


        return root
    }
}