package com.example.demomvp.view

import android.content.Context
import com.example.dbmkotlin.Model.ResultsItem

interface ResultView {
    fun showResults(results: List<ResultsItem>?)
    fun showError(menssaje: String?)
    fun tamanoList(n: Int)
    fun llenarTabla(context: Context)
}