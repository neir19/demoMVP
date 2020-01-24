package com.example.demomvp.presenter.Presenter.searchPresenter

import android.content.Context
import com.example.demomvp.model.SQLite.ResultMovie
import com.example.demomvp.model.Search.SearchIterator
import com.example.demomvp.model.Search.SearchIteratorImpl

class SearchPresenterImpl:SearchPresenter {
   private  var movie: ResultMovie?=null
    private var searchIterator:SearchIterator= SearchIteratorImpl(this)
    override fun getSQLite(title: String,ctx: Context) {
         searchIterator.getSQLite(title,ctx)

    }

    override fun sendMovie(): ResultMovie? {
        return  movie
    }

    override fun getMovie(resultMovie: ResultMovie) {
        movie=resultMovie
    }
}