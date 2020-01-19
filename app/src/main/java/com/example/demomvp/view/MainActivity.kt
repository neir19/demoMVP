package com.example.demomvp.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbmkotlin.Model.ResultsItem
import com.example.demomvp.R
import com.example.demomvp.model.AdapterLanding
import com.example.demomvp.model.DBOpenHelper
import com.example.demomvp.presenter.ResultPesenterImpl
import com.example.demomvp.presenter.ResultPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.db.select

class MainActivity : AppCompatActivity(),ResultView {
    private  var resultPresenter:ResultPresenter?=null
    //pagination
    private  var page=1
    var isLoding: Boolean = true
    var pastVisibleItems = 0
    var visibleItemCount = 0
    var totalItemCount = 0
    var previus_total = 0
    var view_threshold = 20
    val layout=GridLayoutManager(this, 2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress.visibility=View.VISIBLE
        resultPresenter= ResultPesenterImpl(this)
        resultPresenter?.loadList()
        llenarTabla(this)






    }

    override fun showResults(results: List<ResultsItem>?) {

        recycler.layoutManager= layout
        val adapter= AdapterLanding(results  as List<ResultsItem>)
        recycler.adapter= adapter
        progress.visibility=View.GONE
        pagination(layout)


    }


    override fun showError(menssaje: String?) {
        Log.w("errorTt","$menssaje")

    }

    override fun tamanoList(n: Int) {

        Log.e("pagina","$n")
    }

    override fun llenarTabla(context: Context) {
        resultPresenter?.llenarTabla(this)
    }

    fun pagination(layout:GridLayoutManager ){

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                visibleItemCount=layout.childCount
                totalItemCount= layout.itemCount
                pastVisibleItems=layout.findFirstVisibleItemPosition()
                if(dy>0){
                    if(isLoding){
                        if(totalItemCount>previus_total){
                            isLoding=false
                            previus_total=totalItemCount

                        }

                    }
                    if ((!isLoding) && ((totalItemCount - visibleItemCount) <= (pastVisibleItems + view_threshold))){
                        page++
                        resultPresenter?.showPaginationResult(page)
                        isLoding= true

                    }
                }

            }

        })

    }

    override fun onResume() {
        super.onResume()
        val db= DBOpenHelper.getInstance(this)
        db?.use {
            select("Popular").exec {
                Log.e("tamaño", "${this.count}")
            }
        }

        }
    }

