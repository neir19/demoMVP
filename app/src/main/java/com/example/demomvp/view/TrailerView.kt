package com.example.demomvp.view

import com.example.dbmkotlin.Model.trailers.ResultsLinks

interface TrailerView {
    fun ShowResults(trailers: List<ResultsLinks>)
    fun showError(menssaje: String?)
}