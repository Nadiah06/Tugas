package com.example.demo.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private val imagesList = arrayListOf(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTdY22mYduID12Uft_b7C5B2pmuvGVS4WJULVXX4et6yWAenVRoEg&s.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTeYVnu3wtIh0B9H8Pp2bnHyV4MVEFOW35WWTLCWHtbBJHiGmH&s.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQImaop6E6l0EVCEiXgLKlU9MaC1R0GHQsYUn3QvtcQ8C61QQDtGg&s.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJoLNoT_FqXWT60nKkTyq918EwERcBeKzUJ6VEusFB2Yj41I_L&s.jpg",
        "https://www.lauwba.com/img_galeri/kursus-flutter-pertama-di-tahun-2020.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS2q_Vz7ERBfQ1iYXqBWhPCYiBXPnCJRAxTQnWLmAPlEEV8yqqw.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val adapater = AdapterGaleri(imagesList)
        galeri.adapter = adapater
    }
}
