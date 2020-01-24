package com.example.demomvp.model.Result

import android.content.Context
import com.example.demomvp.model.Result.ResultMovie

interface ResultRepository{
   fun getResultsApi( )
   fun Pagination(page:Int,context: Context )
   fun getResultsSQlite( context: Context):List<ResultMovie>



}