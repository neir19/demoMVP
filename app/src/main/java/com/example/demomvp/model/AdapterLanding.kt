package com.example.demomvp.model

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dbmkotlin.Model.ResultsItem
import com.example.dbmmvvm.inflate
import com.example.demomvp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemlanding.view.*

class AdapterLanding( val data: List<ResultsItem>):RecyclerView.Adapter<AdapterLanding.Holder>(){
    class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindView( resultsItem: ResultsItem){
            with(resultsItem){
                itemView.txtTitleItem.text= title
                itemView.txtvoteItem.text=voteAverage.toString()

                var Urll = "https://image.tmdb.org/t/p/w500"
                Picasso.with(itemView.context).load(Urll+backdropPath).into(itemView.imgItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(parent.inflate(R.layout.itemlanding))

    override fun getItemCount(): Int = data?.size?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindView(data.get(position))
    }

}