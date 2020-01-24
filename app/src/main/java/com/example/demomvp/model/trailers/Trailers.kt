package com.example.dbmkotlin.Model.trailers


import com.google.gson.annotations.SerializedName


data class Trailers(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsLinks?>? = null
)