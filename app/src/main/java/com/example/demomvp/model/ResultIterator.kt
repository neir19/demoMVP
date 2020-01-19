package com.example.demomvp.model

import android.content.Context

interface ResultIterator {
    fun loadResult()
    fun Pagination(page:Int, context: Context)

}