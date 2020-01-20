package com.example.demomvp.model

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.dbmkotlin.Model.ResultsItem
import com.example.dbmmvvm.inflate
import com.example.demomvp.R
import com.example.demomvp.view.DetailActivity
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
                itemView.setOnClickListener {

                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("titulo", title)
                    intent.putExtra("año", releaseDate)
                    intent.putExtra("votes", voteAverage)
                    intent.putExtra("desc", overview)
                    intent.putExtra("imagen", backdropPath)
                    intent.putExtra("id", id)




                    val p1: androidx.core.util.Pair<View, String> =
                        androidx.core.util.Pair.create(itemView.imgItem, "transitionImg")
                    val p2: androidx.core.util.Pair<View, String> =
                        androidx.core.util.Pair.create(itemView.txtTitleItem, "transitionTitle")
                    val p3: androidx.core.util.Pair<View, String> =
                        androidx.core.util.Pair.create(itemView.txtvoteItem, "transitionVote")
                    val options: ActivityOptionsCompat =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                            itemView.context as Activity,
                            p1,
                            p2,
                            p3
                        )
                    itemView.context.startActivity(intent, options.toBundle())

                }
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