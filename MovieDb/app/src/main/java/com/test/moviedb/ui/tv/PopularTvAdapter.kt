package com.test.moviedb.ui.tv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.moviedb.R

class ptvAdapter: RecyclerView.Adapter<ptvViewHolder>(){
    override fun getItemCount(): Int {
        return 8
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ptvViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellRowView = layoutInflater.inflate(R.layout.biglayout_listitem, parent, false)
        return ptvViewHolder(cellRowView)
    }

    override fun onBindViewHolder(holder: ptvViewHolder, position: Int) {
        holder?.itemView?.findViewById<TextView>(R.id.title).text = "Title $position"
    }

}
class ptvViewHolder(v: View): RecyclerView.ViewHolder(v) {

}