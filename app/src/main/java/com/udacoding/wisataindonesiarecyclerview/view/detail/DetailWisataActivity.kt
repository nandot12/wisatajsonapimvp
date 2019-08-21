package com.udacoding.wisataindonesiarecyclerview.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udacoding.wisataindonesiarecyclerview.R
import com.udacoding.wisataindonesiarecyclerview.view.home.model.Wisata
import kotlinx.android.synthetic.main.activity_detail_wisata.*

class DetailWisataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)



      val data =  intent.getSerializableExtra("data") as? Wisata

        detailJdl.text = data?.namaTempat

    }
}
