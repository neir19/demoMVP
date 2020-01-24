package com.example.demomvp.view

import android.content.Context
import com.example.dbmkotlin.Model.ResultsItem
import com.example.dbmkotlin.Model.trailers.ResultsLinks

interface ResultView {
    fun showResults(results: List<ResultsItem>?)
    fun showError(menssaje: String?)
    fun tamanoList(n: Int)


}