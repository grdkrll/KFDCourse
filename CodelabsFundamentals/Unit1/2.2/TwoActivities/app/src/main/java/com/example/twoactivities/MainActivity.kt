package com.example.twoactivities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
        const val TEXT_REQUEST = 1
    }

    private val LOG_TAG = MainActivity::class.java.simpleName

    private lateinit var mReplyHeadTextView: TextView
    private lateinit var mReplyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)
        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if (isVisible) {
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.visibility = View.VISIBLE
                mReplyTextView.text = savedInstanceState.getString("reply_text")
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (mReplyHeadTextView.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", mReplyTextView.text.toString());
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

    fun launchSecondActivity1(view: View) {
        Log.d(LOG_TAG, "Button 1 clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, 1)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    fun launchSecondActivity2(view: View) {
        Log.d(LOG_TAG, "Button 2 clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, 2)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    fun launchSecondActivity3(view: View) {
        Log.d(LOG_TAG, "Button 3 clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, 3)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int, data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY)
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = reply
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }
}