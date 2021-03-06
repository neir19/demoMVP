package com.example.demomvp.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dbmkotlin.Model.ResultsItem
import com.example.demomvp.R
import com.example.demomvp.model.Result.AdapterLanding

import com.example.demomvp.model.SQLite.AdapterRM
import com.example.demomvp.model.SQLite.DBOpenHelper
import com.example.demomvp.model.SQLite.ResultMovie
import com.example.demomvp.presenter.Presenter.ResultPresenter.ResultPesenterImpl
import com.example.demomvp.presenter.Presenter.ResultPresenter.ResultPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.db.select

class MainActivity : AppCompatActivity(),ResultView {
    private  var resultPresenter: ResultPresenter?=null
    private  var  estado:Boolean=false

    val layout=GridLayoutManager(this, 2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress.visibility=View.VISIBLE
        fbtnsearch.setOnClickListener {
            val fm: FragmentManager= supportFragmentManager
            val searchFragment=SearchFragment()
            searchFragment.show(fm,"simple fragment")
        }
        resultPresenter=
            ResultPesenterImpl(
                this
            )
        resultPresenter?.loadList()

        if(!estado){
            recycler.layoutManager= layout
            val adater= AdapterRM(
                resultPresenter?.loadListSQLite(this@MainActivity) as List<ResultMovie>
            )
            recycler.adapter=adater
            progress.visibility=View.GONE
        }







    }

    override fun showResults(results: List<ResultsItem>?) {

        recycler.layoutManager= layout
        if(estado){
            val adapter=
                AdapterLanding(results as List<ResultsItem>)
            recycler.adapter= adapter
            progress.visibility=View.GONE
            resultPresenter?.pagination(layout,recycler,this)
        }




    }


    override fun showError(menssaje: String?) {
        Log.w("errorTt","$menssaje")

    }

    override fun tamanoList(n: Int) {

        Log.e("page","$n")
    }


    override fun onPause() {
        super.onPause()
        estado=accessInternet()
    }


    override fun onStart() {
        super.onStart()
        estado=accessInternet()
    }

    override fun onResume() {
        super.onResume()
        estado=accessInternet()

        val db= DBOpenHelper.getInstance(this)
        db?.use {
            select("Popular").exec {
                Log.e("tamañoSQlite", "${this.count}")

            }
        }

        }
    private fun accessInternet(): Boolean {
        val cm=this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo?=cm.activeNetworkInfo
        return networkInfo!=null && networkInfo.isConnected
    }
    }

