package com.example.demomvp.presenter.Presenter.PresenterTrailer

import com.example.dbmkotlin.Model.trailers.ResultsLinks
import com.example.demomvp.model.trailers.TrailerIterator
import com.example.demomvp.model.trailers.TrailerIteratorImpl
import com.example.demomvp.view.TrailerView

class TrailerPresenterImpl(val trailerView: TrailerView):TrailerPresenter {
    private var trailerIterator: TrailerIteratorImpl = TrailerIteratorImpl(this)
    private var trailers =  arrayListOf<ResultsLinks>()

    override fun getTrailers(list: ArrayList<ResultsLinks>) {
        trailers=list
    }

    override fun sendTrailers(): ArrayList<ResultsLinks> {
        return trailers
    }

    override fun loadTrailers(id: Int) {
        trailerIterator.loadTrailers(id)
    }

    override fun sendTrailersList(list: ArrayList<ResultsLinks>) {
        trailerView.ShowResults(list)
    }


}