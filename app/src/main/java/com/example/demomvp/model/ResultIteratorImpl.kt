package com.example.demomvp.model

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvp.presenter.ResultPresenter
import com.example.demomvp.view.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

class ResultIteratorImpl( var resultPresenter: ResultPresenter):ResultIterator {
    var page =1
    var resultRepository:ResultRepository= ResultRepositoryImpl(resultPresenter)
    override fun loadResult() {
       resultRepository.getResultsApi()
    }


    override fun loadResultSQlite(context: Context):List<ResultMovie> {
        return resultRepository.getResultsSQlite(context)
    }

    override fun pagination(layout: GridLayoutManager, recycler:RecyclerView,context: Context) {

        var isLoding: Boolean = true
        var pastVisibleItems = 0
        var visibleItemCount = 0
        var totalItemCount = 0
        var previus_total = 0
        var view_threshold = 20


            recycler.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    visibleItemCount=layout.childCount
                    totalItemCount= layout.itemCount
                    pastVisibleItems=layout.findFirstVisibleItemPosition()
                    if(dy>0){
                        if(isLoding){
                            if(totalItemCount>previus_total){
                                isLoding=false
                                previus_total=totalItemCount

                            }

                        }
                        if ((!isLoding) && ((totalItemCount - visibleItemCount) <= (pastVisibleItems + view_threshold))){
                            page++
                            resultRepository.Pagination(page,context)
                            isLoding= true

                        }
                    }

                }

            })


    }


}