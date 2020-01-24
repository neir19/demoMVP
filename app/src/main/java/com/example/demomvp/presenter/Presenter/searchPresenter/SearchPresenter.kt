package com.example.demomvp.presenter.Presenter.searchPresenter

import android.content.Context
import com.example.demomvp.model.SQLite.ResultMovie

interface SearchPresenter {
    fun getSQLite(title: String, ctx: Context)
    fun getMovie(movie: ResultMovie)
    fun  sendMovie():ResultMovie?


}