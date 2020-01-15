package com.example.demo.recyclerviewexample

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demo.R
import com.example.demo.maps.MapsActivity
import kotlinx.android.synthetic.main.item_adapter_galeri.view.*

class AdapterGaleri (private val daftarGambar : List<String>) : RecyclerView.Adapter<AdapterGaleri.ViewHolder>(){
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val gambar = itemView.gambarGaleri
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_adapter_galeri, parent, false))
    }

    override fun getItemCount(): Int {
        return daftarGambar.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val progress = CircularProgressDrawable(holder.itemView.context)
        Glide.with(holder.itemView.context).load(daftarGambar.get(position))
            .into(holder.gambar)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, daftarGambar.get(position),
                Toast.LENGTH_SHORT).show()

            val detail = Intent(holder.itemView.context, MapsActivity:: class.java)
            detail.putExtra("judul", "Lauwba Techno Indonesia")
            detail.putExtra("deskripsi", "Deskripsi Tentang Lauwba")
            detail.putExtra("lat", -7.6078685 )
            detail.putExtra("lon", 110.2015626)
            holder.itemView.context.startActivity(detail)
        }
    }

}
