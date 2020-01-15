package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo.recyclerviewexample.RecyclerViewActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.webView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleview.setOnClickListener {
            startActivity(Intent(this@MainActivity, RecyclerViewActivity::class.java))
        }

        webView.setOnLongClickListener {
            val webview = Intent (this@MainActivity, WebViewActivity::class.java)
            webview.putExtra("url", "https://facebook.com")
            startActivity(webview)
            return@setOnLongClickListener true
        }
    }
}
