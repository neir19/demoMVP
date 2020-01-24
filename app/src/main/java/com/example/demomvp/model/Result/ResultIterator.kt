package com.example.demomvp.model.Result

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvp.model.SQLite.ResultMovie

interface ResultIterator {
    fun loadResult()

    fun loadResultSQlite(context: Context):List<ResultMovie>
    fun pagination(layout:GridLayoutManager,recyclerView: RecyclerView,context: Context)

}