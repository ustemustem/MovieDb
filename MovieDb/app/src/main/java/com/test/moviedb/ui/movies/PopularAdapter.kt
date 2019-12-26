package com.test.moviedb.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.moviedb.R

class pmAdapter: RecyclerView.Adapter<pmViewHolder>(){
    override fun getItemCount(): Int {
        return 8
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pmViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellRowView = layoutInflater.inflate(R.layout.smalllayout_listitem, parent, false)
        return pmViewHolder(cellRowView)
    }

    override fun onBindViewHolder(holder: pmViewHolder, position: Int) {
        holder?.itemView?.findViewById<TextView>(R.id.title).text = "Title $position"
    }

}
class pmViewHolder(v: View): RecyclerView.ViewHolder(v) {

}