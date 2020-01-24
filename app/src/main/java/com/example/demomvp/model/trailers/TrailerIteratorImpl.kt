package com.example.demomvp.model.trailers

import com.example.dbmkotlin.Model.trailers.ResultsLinks
import com.example.demomvp.presenter.Presenter.PresenterTrailer.TrailerPresenter

class TrailerIteratorImpl(var trailerPresenter: TrailerPresenter):TrailerIterator {
    private var trailerRepository:TrailerRepository=TrailerRepositoryImpl(trailerPresenter)


    override fun loadTrailers(id: Int) {
       trailerRepository.getTrailers(id)
    }
}