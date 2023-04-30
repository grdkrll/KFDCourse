package com.example.implicitintentsreceiver

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text_uri_message)

        val intent = intent
        val uri = intent.data
        if(uri != null) {
            val uriString = "URI: $uri"
            textView?.text = uriString
        }
    }
}