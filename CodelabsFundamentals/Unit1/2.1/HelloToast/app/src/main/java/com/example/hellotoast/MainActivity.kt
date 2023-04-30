package com.example.hellotoast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE"
    }

    private var mCount = 0
    private lateinit var mShowCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mShowCount = findViewById(R.id.show_count)
    }

    fun showToast(view: View) {
        val intent = Intent(this, HelloActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, mCount)
        startActivity(intent)
    }

    fun countUp(view: View) {
        ++mCount
        mShowCount.text = mCount.toString()
    }
}