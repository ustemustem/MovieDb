package com.test.moviedb.ui.tv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.moviedb.R

class tvAdapter: RecyclerView.Adapter<tvViewHolder>(){
    override fun getItemCount(): Int {
        return 8
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tvViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellRowView = layoutInflater.inflate(R.layout.smalllayout_listitem, parent, false)
        return tvViewHolder(cellRowView)
    }

    override fun onBindViewHolder(holder: tvViewHolder, position: Int) {
        holder?.itemView?.findViewById<TextView>(R.id.title).text = "Title $position"
    }

}
class tvViewHolder(v: View): RecyclerView.ViewHolder(v) {

}