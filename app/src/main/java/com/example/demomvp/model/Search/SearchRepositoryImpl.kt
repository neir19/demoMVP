package com.example.demomvp.model.Search

import android.content.Context
import com.example.demomvp.model.SQLite.DBOpenHelper
import com.example.demomvp.model.SQLite.ResultMovie
import com.example.demomvp.presenter.Presenter.searchPresenter.SearchPresenter
import org.jetbrains.anko.db.select

class SearchRepositoryImpl(var searchPresenter: SearchPresenter):SearchRepository {
    override fun getSQLite(title: String,ctx: Context) {
        val db = DBOpenHelper.getInstance(ctx)
        var movie:ResultMovie
        db?.use {
            select("Popular").exec {
                if (this.count == 0) {
                } else {
                    this.moveToNext()
                    do{
                        if(title.equals(this.getString(1))){
                            movie= ResultMovie(this.getInt(0),this.getString(1),this.getString(2),this.getString(3),this.getString(4),this.getDouble(5))
                            searchPresenter.getMovie(movie)
                            break
                        }

                    }while (this.moveToNext())
                }
            }
        }

    }
}