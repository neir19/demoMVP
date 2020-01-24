package com.example.demomvp.model.trailers

import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dbmkotlin.Model.trailers.ResultsLinks

import com.example.dbmmvvm.inflate
import com.example.demomvp.R
import kotlinx.android.synthetic.main.itemvideoview.view.*

class AdapterTrailer(var data: List<ResultsLinks>):RecyclerView.Adapter<AdapterTrailer.Holder>() {
    class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bindView(resultsLinks: ResultsLinks){
            with(resultsLinks){
                itemView.txtvideoTitle.text=name
                itemView.setOnClickListener {
                    val intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=${key}"))
                    //intent.putExtra("VIDEO_ID",key)
                    itemView.context.startActivity(intent)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(parent.inflate(R.layout.itemvideoview))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindView(data[position])
    }
}