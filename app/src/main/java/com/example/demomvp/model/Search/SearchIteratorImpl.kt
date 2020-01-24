package com.example.demomvp.model.Search

import android.content.Context
import com.example.demomvp.model.SQLite.ResultMovie
import com.example.demomvp.presenter.Presenter.searchPresenter.SearchPresenter

class SearchIteratorImpl(var searchPresenter: SearchPresenter): SearchIterator {
    private var searchRepository: SearchRepository= SearchRepositoryImpl(searchPresenter)
    override fun getSQLite(title: String,ctx: Context) {
         searchRepository.getSQLite(title,ctx)
    }
}