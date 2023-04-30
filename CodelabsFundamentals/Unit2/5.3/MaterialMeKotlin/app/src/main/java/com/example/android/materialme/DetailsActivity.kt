package com.example.android.materialme

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val sportsTitle: TextView = findViewById(R.id.titleDetail)
        val sportsImage: ImageView = findViewById(R.id.sportsImageDetail)
        sportsTitle.text = intent.getStringExtra("title")
        Glide.with(this).load(intent.getIntExtra("image_resource", 0))
            .into(sportsImage)
        val sportsDetails: TextView = findViewById(R.id.detailsDetail)
        sportsDetails.text = intent.getStringExtra("details")
    }
}