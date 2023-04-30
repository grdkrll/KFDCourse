package com.example.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HelloActivity : AppCompatActivity() {
    lateinit var counterView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        counterView = findViewById(R.id.counter_second)
        val message = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0)
        counterView.text = message.toString()
    }
}