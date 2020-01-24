package com.example.demomvp.presenter.Presenter.PresenterTrailer

import com.example.dbmkotlin.Model.trailers.ResultsLinks

interface TrailerPresenter {
    fun getTrailers(list:ArrayList<ResultsLinks>)
    fun sendTrailers():ArrayList<ResultsLinks>
    fun loadTrailers(id: Int)
    fun  sendTrailersList(list:ArrayList<ResultsLinks>)
}