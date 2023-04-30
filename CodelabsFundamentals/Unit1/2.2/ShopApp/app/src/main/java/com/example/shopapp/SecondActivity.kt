package com.example.shopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SecondActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun addMilk(view: View) {
        val replyIntent = Intent()
        val reply = "Milk"
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    fun addChocolate(view: View) {
        val replyIntent = Intent()
        val reply = "Chocolate"
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    fun addTomatoes(view: View) {
        val replyIntent = Intent()
        val reply = "Tomatoes"
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    fun addRice(view: View) {
        val replyIntent = Intent()
        val reply = "Rice"
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    fun addApples(view: View) {
        val replyIntent = Intent()
        val reply = "Apples"
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    fun addCheese(view: View) {
        val replyIntent = Intent()
        val reply = "Cheese"
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }
}