package com.udacoding.wisataindonesiarecyclerview.view.home.presenter

import com.udacoding.wisataindonesiarecyclerview.view.home.model.Wisata

interface HomeView {


    fun onSuccess(data : List<Wisata?>?,status : Int)
    fun onError(msg : String)
}