package com.example.demomvp.model

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dbmmvvm.inflate
import com.example.demomvp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemlanding.view.*

class AdapterRM(val data: List<ResultMovie>):RecyclerView.Adapter<AdapterRM.Holder>() {
    class Holder( itemView: View): RecyclerView.ViewHolder(itemView) {
        fun BindView(movie: ResultMovie) {
            with(movie) {
                itemView.txtTitleItem.text = titulo
                itemView.txtvoteItem.text = votos.toString()
                var Urll = "https://image.tmdb.org/t/p/w500"
                Picasso.with(itemView.context).load(Urll + img).into(itemView.imgItem)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(parent.inflate(R.layout.itemlanding))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder.BindView(data[position])
    }
}