package com.example.dbmmvvm

import android.app.Activity
import android.content.Context
import android.provider.SyncStateContract.Helpers.insert
import android.system.Os.close
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.dbmkotlin.Model.ResultsItem
import com.example.demomvp.model.DBOpenHelper
import com.example.demomvp.model.ResultRepositoryImpl
import com.example.demomvp.presenter.ResultPesenterImpl
import com.example.demomvp.presenter.ResultPresenter
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

fun Activity.toast(mensaje: String){
    Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show()
}
fun ViewGroup.inflate(layoutid: Int): View {
    return LayoutInflater.from(context).inflate(layoutid, this , false)

}


