package com.example.helloconstraint

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var mCount = 0
    private lateinit var mShowCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mShowCount = findViewById(R.id.show_count)
    }

    fun showToast(view: View) {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }

    fun countUp(view: View) {
        ++mCount
        mShowCount.text = mCount.toString()
        val btn = findViewById<Button>(R.id.button_zero)
        btn.setBackgroundColor(Color.MAGENTA)

    }

    fun zero(view: View) {
        if(mCount != 0) {
            val btn = findViewById<Button>(R.id.button_zero)
            btn.setBackgroundColor(Color.LTGRAY)
        }
    }
}