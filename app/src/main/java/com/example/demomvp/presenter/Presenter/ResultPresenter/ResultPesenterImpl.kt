package com.example.demomvp.presenter.Presenter.ResultPresenter

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbmkotlin.Model.ResultsItem
import com.example.demomvp.model.Result.ResultIterator
import com.example.demomvp.model.Result.ResultIteratorImpl
import com.example.demomvp.model.SQLite.ResultMovie

import com.example.demomvp.view.ResultView

class ResultPesenterImpl(var resultView: ResultView):
    ResultPresenter {
  private  var resultIterator: ResultIterator =
      ResultIteratorImpl(this)
  private var results= arrayListOf<ResultsItem>()

    private var resultsSQlite= arrayListOf<ResultMovie>()

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

    override fun loadListSQLite(context: Context):List<ResultMovie> {
        return resultIterator.loadResultSQlite(context)
    }





    override fun pagination(layout: GridLayoutManager,recyclerView: RecyclerView,context: Context) {
        resultIterator.pagination(layout,recyclerView,context)
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


    override fun loadList() {
        resultIterator.loadResult()
    }
}