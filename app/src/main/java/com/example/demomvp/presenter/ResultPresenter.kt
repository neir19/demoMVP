package com.example.demomvp.presenter

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbmkotlin.Model.ResultsItem
import com.example.demomvp.model.ResultMovie

interface ResultPresenter {
    fun sendListView(results:List<ResultsItem>?)
    fun loadList()
    fun ShowErrorLoadResult(messanje:String?)
    fun tamanoList(n: Int?)

    fun llenarList(list: List<ResultsItem>?)
    fun sendList():ArrayList<ResultsItem>
    fun loadListSQLite(context: Context):List<ResultMovie>
    fun pagination(layout: GridLayoutManager,recyclerView: RecyclerView,context: Context)


}