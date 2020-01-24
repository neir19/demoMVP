package com.example.demomvp.model.Search

import android.content.Context
import com.example.demomvp.model.SQLite.ResultMovie

interface SearchIterator {
    fun getSQLite(title: String,ctx: Context)
}