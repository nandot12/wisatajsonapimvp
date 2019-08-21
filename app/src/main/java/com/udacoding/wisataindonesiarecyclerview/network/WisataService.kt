package com.udacoding.wisataindonesiarecyclerview.network

import com.udacoding.wisataindonesiarecyclerview.view.home.model.ResultWisata
import retrofit2.Call
import retrofit2.http.GET

interface WisataService {


    @GET("?action=findAll")
    fun ambilWisata():Call<ResultWisata>
}