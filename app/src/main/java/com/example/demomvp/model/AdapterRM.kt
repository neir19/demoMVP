package com.example.demomvp.model

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.dbmmvvm.inflate
import com.example.demomvp.R
import com.example.demomvp.view.DetailActivity
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
                itemView.setOnClickListener {

                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("titulo", titulo)
                    intent.putExtra("año", año)
                    intent.putExtra("votes", votos)
                    intent.putExtra("desc", desc)
                    intent.putExtra("imagen", img)
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

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder.BindView(data[position])
    }
}