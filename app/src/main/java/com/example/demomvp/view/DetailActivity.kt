package com.example.demomvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbmkotlin.Model.trailers.ResultsLinks
import com.example.demomvp.R
import com.example.demomvp.model.trailers.AdapterTrailer
import com.example.demomvp.presenter.Presenter.PresenterTrailer.TrailerPresenter
import com.example.demomvp.presenter.Presenter.PresenterTrailer.TrailerPresenterImpl
import com.example.demomvp.presenter.Presenter.ResultPresenter.ResultPesenterImpl
import com.example.demomvp.presenter.Presenter.ResultPresenter.ResultPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_descr.*

class DetailActivity : AppCompatActivity(), TrailerView {
    private  var trailerPresenter:TrailerPresenter?=null

    var id: Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent.extras.let {
            var Urlll: String = "https://image.tmdb.org/t/p/w500"
            val titl = it?.getString("titulo")
            val yer = it?.getString("año")
            val descr = it?.getString("desc")
            val vote = it?.getDouble("votes")
            id = it?.getInt("id")
            val imgg = it?.getString("imagen")

            txttitledetail.text = it?.getString("titulo")
            txtyeardetail.text = it?.getString("año")
            txtdescdetail.text = it?.getString("desc")
            txtvotedetail.text = it?.getDouble("votes").toString()
            Picasso.with(this).load(Urlll + it?.getString("imagen")).into(imgdetail)
        }
        trailerPresenter= TrailerPresenterImpl(this)
        trailerPresenter?.loadTrailers(id!!)

    }



    override fun showError(menssaje: String?) {

    }


    override fun ShowResults(trailers: List<ResultsLinks>) {
        recyTrailers.layoutManager= LinearLayoutManager(this)
        val adapter= AdapterTrailer(trailers)
        recyTrailers.adapter= adapter
    }
}
