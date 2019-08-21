package com.udacoding.wisataindonesiarecyclerview.view.home.model

import com.google.gson.annotations.SerializedName

data class ResultWisata(

	@field:SerializedName("status_code")
	val statusCode: Int? = null,

	val data: List<Wisata?>? = null,

	val message: String? = null
)