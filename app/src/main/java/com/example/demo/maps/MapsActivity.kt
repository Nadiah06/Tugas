package com.example.demo.maps

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.demo.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : FragmentActivity(), OnMapReadyCallback {

    private var latling : LatLng? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val judul = intent.getStringExtra("judul")
        val deskripsi = intent.getStringExtra("deskripsi")
        val latitude = intent.getDoubleExtra("lat",0.0)
        val longitude = intent.getDoubleExtra("lon", 0.0)

        latling = LatLng (latitude, longitude)
        judulWisata.text = judul
        deskripsiTxt.text = deskripsi

        val mapFragment = supportFragmentManager.findFragmentById(R.id.maps) as SupportMapFragment
        mapFragment.getMapAsync(this)


        navigasi.setOnClickListener {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.co.id/maps/@$latitude,$longitude,17z")
        startActivity(Intent.createChooser(intent, "Lanjutkan dengan...."))
    }
    }

    override fun onMapReady(p0: GoogleMap?) {
        val maps = p0
        val marker = maps?.addMarker(MarkerOptions().position(latling!!).title(judulWisata.text.toString()))
        marker?.showInfoWindow()
        maps?.animateCamera(CameraUpdateFactory.newLatLngZoom(latling, 15f))
    }
}
