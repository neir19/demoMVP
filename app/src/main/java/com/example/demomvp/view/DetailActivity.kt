package com.example.demomvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demomvp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_descr.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent.extras.let {
            var Urlll: String = "https://image.tmdb.org/t/p/w500"
            val titl = it?.getString("titulo")
            val yer = it?.getString("año")
            val descr = it?.getString("desc")
            val vote = it?.getDouble("votes")
            val idd = it?.getInt("id")
            val imgg = it?.getString("imagen")

            txttitledetail.text = it?.getString("titulo")
            txtyeardetail.text = it?.getString("año")
            txtdescdetail.text = it?.getString("desc")
            txtvotedetail.text = it?.getDouble("votes").toString()
            Picasso.with(this).load(Urlll + it?.getString("imagen")).into(imgdetail)
        }
    }
}
