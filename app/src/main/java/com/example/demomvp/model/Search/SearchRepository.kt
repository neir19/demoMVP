package com.example.demomvp.model.Search

import android.content.Context
import com.example.demomvp.model.SQLite.ResultMovie

interface SearchRepository {
    fun getSQLite(title: String,ctx: Context)
}