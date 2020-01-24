package com.example.demomvp.model.trailers

import com.example.dbmkotlin.Model.trailers.ResultsLinks
import com.example.dbmkotlin.Model.trailers.Trailers
import com.example.demomvp.model.Endpoints
import com.example.demomvp.presenter.Presenter.PresenterTrailer.TrailerPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrailerRepositoryImpl(var trailerPresenter: TrailerPresenter):TrailerRepository{
    private  var retro= Endpoints.create()
    val api_key = "02e4b138dacaf8151088a361d6e75d01"
    override fun getTrailers(id: Int) {
        retro
            .getTrailers(id,api_key)
            .enqueue(object : Callback<Trailers> {
                override fun onFailure(call: Call<Trailers>, t: Throwable) {

                }

                override fun onResponse(call: Call<Trailers>, response: Response<Trailers>) {
                    trailerPresenter.sendTrailersList(response.body()?.results as ArrayList<ResultsLinks>)
                }

            })


    }

}