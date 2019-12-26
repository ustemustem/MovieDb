package com.test.moviedb.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.moviedb.R

class npmAdapter: RecyclerView.Adapter<npmViewHolder>(){
    override fun getItemCount(): Int {
        return 8
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): npmViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellRowView = layoutInflater.inflate(R.layout.smalllayout_listitem, parent, false)
        return npmViewHolder(cellRowView)
    }

    override fun onBindViewHolder(holder: npmViewHolder, position: Int) {
        holder?.itemView?.findViewById<TextView>(R.id.title).text = "Title $position"
    }

}
class npmViewHolder(v: View): RecyclerView.ViewHolder(v) {

}