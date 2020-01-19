package com.example.dbmmvvm

import android.app.Activity
import android.content.Context
import android.provider.SyncStateContract.Helpers.insert
import android.system.Os.close
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.dbmkotlin.Model.ResultsItem
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

fun Activity.toast(mensaje: String){
    Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show()
}
fun ViewGroup.inflate(layoutid: Int): View {
    return LayoutInflater.from(context).inflate(layoutid, this , false)
}


