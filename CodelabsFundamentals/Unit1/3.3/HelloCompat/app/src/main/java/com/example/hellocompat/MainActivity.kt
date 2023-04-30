package com.example.hellocompat

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.Random
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {

    private var mHelloTextView: TextView? = null
    private val mColorArray = arrayOf(
        "red", "pink", "purple", "deep_purple",
        "indigo", "blue", "light_blue", "cyan", "teal", "green",
        "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
        "brown", "grey", "blue_grey", "black"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mHelloTextView = findViewById(R.id.hello_textview)
        if (savedInstanceState != null) {
            mHelloTextView?.setTextColor(savedInstanceState.getInt("color"))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("color", mHelloTextView!!.currentTextColor)
    }

    fun changeColor(view: View) {
        val random = Random();
        val color = mColorArray[random.nextInt(20)]
        val colorResourceName = resources.getIdentifier(
            color,
            "color", applicationContext.packageName
        )
        val colorRes = if(Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            ContextCompat.getColor(this, colorResourceName)
        } else {
            resources.getColor(colorResourceName, this.theme)
        }
        mHelloTextView?.setTextColor(colorRes)
    }
}