package com.udacoding.wisataindonesiarecyclerview.view.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacoding.wisataindonesiarecyclerview.R
import com.udacoding.wisataindonesiarecyclerview.view.home.model.Wisata
import com.udacoding.wisataindonesiarecyclerview.view.detail.DetailWisataActivity
import com.udacoding.wisataindonesiarecyclerview.view.home.MainActivity
import kotlinx.android.synthetic.main.item_wisata.view.*

class WisataAdapter(
    var namaWisata: List<Wisata?>?,
    var m: MainActivity
) : RecyclerView.Adapter<WisataAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        MyHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_wisata,
                parent,
                false
            )
        )
    override fun getItemCount(): Int {

        return namaWisata?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(namaWisata?.get(position))


        holder.itemView.setOnClickListener {


            var intent = Intent(m,
                DetailWisataActivity::class.java)

            intent.putExtra("data",namaWisata?.get(position))
            m.startActivity(intent)


        }
    }


    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: Wisata?) {

            itemView.itemDesk.text = get?.namaTempat
            itemView.itemDesk.text = ""

        }


    }
}