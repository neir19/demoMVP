package com.example.demomvp.presenter

import android.content.Context
import com.example.dbmkotlin.Model.ResultsItem

interface ResultPresenter {
    fun sendListView(results:List<ResultsItem>?)
    fun loadList()
    fun ShowErrorLoadResult(messanje:String?)
    fun tamanoList(n: Int?)
    fun showPaginationResult(page: Int)
    fun llenarList(list: List<ResultsItem>?)
    fun sendList():ArrayList<ResultsItem>
    fun llenarTabla(context: Context)
}