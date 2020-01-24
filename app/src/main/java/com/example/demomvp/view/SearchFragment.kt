package com.example.demomvp.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.demomvp.R
import com.example.demomvp.presenter.Presenter.searchPresenter.SearchPresenter
import com.example.demomvp.presenter.Presenter.searchPresenter.SearchPresenterImpl
import org.jetbrains.anko.db.TEXT

class SearchFragment: DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View= inflater.inflate(R.layout.fragment_search,container,false)
        var bsearch= rootView.findViewById<Button>(R.id.btnSearch)
        var txtSearch= rootView.findViewById<EditText>(R.id.txtsearch)

        bsearch.setOnClickListener {
            val intent= Intent(rootView.context, DetailActivity::class.java)
            val searchPresenter= SearchPresenterImpl()
            searchPresenter.getSQLite(txtSearch.text.toString(),rootView.context)
            var movie= searchPresenter.sendMovie()
            if(movie!= null) {
                movie.let {

                    intent.putExtra("titulo", it.titulo)
                    intent.putExtra("año", it.año)
                    intent.putExtra("desc", it.desc)
                    intent.putExtra("votes", it.votos)
                    intent.putExtra("imagen", it.img)
                    intent.putExtra("id", it.id)
                    rootView.context.startActivity(intent)
                    dismiss()
                }
            }
            else{

                Toast.makeText(rootView.context,"pelicula no encontrada",Toast.LENGTH_SHORT).show()
            }


        }
        return  rootView

    }
}