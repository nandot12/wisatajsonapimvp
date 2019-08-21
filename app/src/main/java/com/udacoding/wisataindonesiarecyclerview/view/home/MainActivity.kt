package com.udacoding.wisataindonesiarecyclerview.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.udacoding.wisataindonesiarecyclerview.R
import com.udacoding.wisataindonesiarecyclerview.view.home.adapter.WisataAdapter
import com.udacoding.wisataindonesiarecyclerview.view.home.model.Wisata
import com.udacoding.wisataindonesiarecyclerview.view.home.presenter.HomePresenter
import com.udacoding.wisataindonesiarecyclerview.view.home.presenter.HomeView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HomeView {


//

    //deklrasi prsenter
    private var homePresenter : HomePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //initialisasi presenter

        progressbar.visibility = View.VISIBLE
        homePresenter = HomePresenter(this)

        homePresenter?.getWisata()


        //request ke server



    }

    override fun onSuccess(data: List<Wisata?>?, status: Int) {
        progressbar.visibility = View.GONE

        listWisata.adapter = WisataAdapter(data as List<Wisata>?,this@MainActivity)
    }

    override fun onError(msg: String) {
        progressbar.visibility = View.GONE
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }


}
