package com.example.demomvp.model

import android.content.Context

interface ResultRepository{
   fun getResultsApi( )
   fun Pagination(page:Int )
   fun llenarTabla(context: Context)
}