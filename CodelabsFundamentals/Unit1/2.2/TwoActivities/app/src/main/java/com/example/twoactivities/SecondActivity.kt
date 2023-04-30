package com.example.twoactivities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
        private val LOG_TAG = SecondActivity::class.java.simpleName
    }

    private var mReply: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent = intent
        val message = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0)
        val textView = findViewById<TextView>(R.id.text_message)
        mReply = findViewById(R.id.editText_second);
        textView.text = when (message) {
            1 -> "Hello World! First"
            2 -> "Hello World! Second"
            3 -> "Hello World! Third"
            else -> {
                "Something went wrong"
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart");
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause");
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart");
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume");
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy");
    }

    fun returnReply(view: View) {
        val replyIntent = Intent()
        val reply = mReply?.text.toString()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        Log.d(LOG_TAG, "End SecondActivity");
        finish()
    }
}