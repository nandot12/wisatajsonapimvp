package com.udacoding.wisataindonesiarecyclerview.view.home.presenter

import com.udacoding.wisataindonesiarecyclerview.view.home.model.ResultWisata
import com.udacoding.wisataindonesiarecyclerview.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(val homeView : HomeView) {



    fun getWisata(){

        NetworkConfig.service().ambilWisata().enqueue(object : Callback<ResultWisata> {
            override fun onFailure(call: Call<ResultWisata>, t: Throwable) {

                homeView.onError(t.localizedMessage)

            }

            //jika responsenya ada
            override fun onResponse(call: Call<ResultWisata>, response: Response<ResultWisata>) {

                //check response success apa enggak
                if(response.isSuccessful){

                    //  Log.d("data widata",response.body()?.data?.get(0).toString())

                    val statusCode = response.body()?.statusCode

                    if(statusCode == 200){


                        //bind data ke recyclerview
                        val data = response?.body()?.data

                        homeView.onSuccess(data,statusCode)



                    }
                    else{


                        homeView.onError(response?.body()?.message ?: "")
                    }




                }

            }
        })




    }
}