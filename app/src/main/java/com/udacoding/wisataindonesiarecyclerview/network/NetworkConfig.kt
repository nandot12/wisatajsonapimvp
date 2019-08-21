package com.udacoding.wisataindonesiarecyclerview.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor



object NetworkConfig {


    fun initIntterceptor() :OkHttpClient{

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return  client
    }


    //convfigurasi retrofit

    fun initRetrofit() : Retrofit {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://www.udacoding.com/api/")
            .client(initIntterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit

    }

    fun service(): WisataService {
        return  initRetrofit().create(WisataService::class.java)



    }





}