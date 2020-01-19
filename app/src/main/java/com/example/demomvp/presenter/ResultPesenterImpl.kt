package com.example.demomvp.presenter

import android.content.Context
import com.example.dbmkotlin.Model.ResultsItem
import com.example.demomvp.model.ResultIterator
import com.example.demomvp.model.ResultIteratorImpl
import com.example.demomvp.view.ResultView

class ResultPesenterImpl(var resultView: ResultView):ResultPresenter {
  private  var resultIterator:ResultIterator= ResultIteratorImpl(this)
  private var results= arrayListOf<ResultsItem>()
    override fun llenarList(List: List<ResultsItem>?){
        if (List != null) {
            for(i:ResultsItem in List){
                results.add(i)
            }
        }
    }

    override fun sendList(): ArrayList<ResultsItem> {
        return results
    }



    override fun sendListView(results: List<ResultsItem>?) {
       resultView.showResults(results)
    }

    override fun ShowErrorLoadResult(messanje: String?) {
        resultView.showError(messanje)
    }

    override fun tamanoList(n: Int?) {
        if(n!=null){
            resultView.tamanoList(n)
        }else{
            resultView.tamanoList(0)
        }

    }

    override fun showPaginationResult(page: Int, context: Context) {
        resultIterator.Pagination(page, context)
    }

    override fun loadList() {
        resultIterator.loadResult()
    }
}