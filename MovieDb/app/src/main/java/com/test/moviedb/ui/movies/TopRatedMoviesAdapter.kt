package com.test.moviedb.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.moviedb.R

class trmAdapter: RecyclerView.Adapter<trmViewHolder>(){
    override fun getItemCount(): Int {
        return 8
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): trmViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellRowView = layoutInflater.inflate(R.layout.biglayout_listitem, parent, false)
        return trmViewHolder(cellRowView)
    }

    override fun onBindViewHolder(holder:trmViewHolder, position: Int) {
        holder?.itemView?.findViewById<TextView>(R.id.title).text = "Title $position"
    }

}
class trmViewHolder(v: View): RecyclerView.ViewHolder(v) {

}
