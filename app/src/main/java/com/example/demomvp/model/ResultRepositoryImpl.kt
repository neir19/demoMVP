package com.example.demomvp.model

import android.content.Context
import android.util.Log
import com.example.dbmkotlin.Model.Movies
import com.example.dbmkotlin.Model.ResultsItem
import com.example.demomvp.presenter.ResultPresenter
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultRepositoryImpl(var resultPresenter: ResultPresenter):ResultRepository {

    private  var retro=Endpoints.create()
    override fun getResultsApi() {
        val api_key = "02e4b138dacaf8151088a361d6e75d01"


        retro
          .getPopular(api_key, 1)
          .enqueue(object : Callback<Movies>{
              override fun onFailure(call: Call<Movies>, t: Throwable) {
                  resultPresenter.ShowErrorLoadResult(t.message)
              }
              override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                  if(response.isSuccessful){
                      resultPresenter.llenarList(response.body()?.results as List<ResultsItem>?)
                      resultPresenter.sendListView(resultPresenter.sendList())
                  }
              }
          })
    }

    override fun Pagination(page: Int,context: Context) {
        val api_key = "02e4b138dacaf8151088a361d6e75d01"
        resultPresenter.tamanoList(page)

        retro
            .getPopular(api_key, page)
            .enqueue(object : Callback<Movies>{
                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    resultPresenter.ShowErrorLoadResult(t.message)
                }
                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    if(response.isSuccessful){

                        resultPresenter.llenarList(response.body()?.results as List<ResultsItem>?)
                        llenarTabla(context,resultPresenter.sendList())

                    }
                }
            })
    }

    override fun getResultsSQlite(context: Context):ArrayList<ResultMovie> {
    val db=DBOpenHelper.getInstance(context)
        val list= arrayListOf<ResultMovie>()
        db?.use {
            select("Popular").exec {

                if(this.count!=0){
                    this.moveToFirst()
                    do{
                        list.add(ResultMovie(
                            this.getInt(0),
                            this.getString(1)?:"",
                            this.getString(3)?:"",
                            this.getString(2)?:"",
                            this.getString(4)?:"",
                            this.getDouble(5)))

                    }while(this.moveToNext())
                }
            }
        }

        return  list
    }

    fun llenarTabla(context: Context,list:ArrayList<ResultsItem>) {


        val db= DBOpenHelper.getInstance(context)
        var count: Int=0
        db?.use {
            select("Popular").exec {
                for(item:ResultsItem in list){
                    if (this.count != 0) {


                        this.moveToFirst()
                        do {
                            if (item.id == this.getInt(0)) {
                                count++
                                break
                            } else {
                                count = 0
                            }
                        }while (this.moveToNext())

                        if(count==0) {
                            val idPr = "id" to item.id
                            val namePr = "titulo" to item.title
                            val yearPr = "año" to item.releaseDate
                            val descPr = "desc" to item.overview
                            val imgPr  ="img" to item.backdropPath
                            val votesPr = "votos" to item.voteAverage
                            insert("Popular", idPr, namePr, yearPr, descPr,imgPr, votesPr)
                        }
                    }else{
                        val idPr = "id" to item.id
                        val namePr = "titulo" to item.originalTitle
                        val yearPr = "año" to item.releaseDate
                        val descPr = "desc" to item.overview
                        val imgPr  ="img" to item.backdropPath
                        val votesPr = "votos" to item.voteAverage
                        insert("Popular", idPr, namePr, yearPr, descPr,imgPr, votesPr)
                    }


                }
            }
        }

    }

}
