package com.example.demomvp.model

import android.content.Context

interface ResultRepository{
   fun getResultsApi( )
   fun Pagination(page:Int,context: Context )
   fun getResultsSQlite( context: Context):List<ResultMovie>

}