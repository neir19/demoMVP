package com.example.demomvp.model

import android.content.Context
import com.example.demomvp.presenter.ResultPresenter

class ResultIteratorImpl( var resultPresenter: ResultPresenter):ResultIterator {
    var resultRepository:ResultRepository= ResultRepositoryImpl(resultPresenter)
    override fun loadResult() {
       resultRepository.getResultsApi()
    }

    override fun Pagination(page:Int,context: Context) {
        resultRepository.Pagination(page,context)
    }


}