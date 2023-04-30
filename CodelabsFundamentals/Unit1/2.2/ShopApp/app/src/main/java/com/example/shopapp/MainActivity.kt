package com.example.shopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import java.util.LinkedList
import java.util.Queue

class MainActivity : AppCompatActivity() {

    private var listTextView = mutableListOf<TextView>()
    private var items = ArrayDeque<String>()

    companion object {
        const val TEXT_REQUEST = 1
    }

    private val LOG_TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listTextView.add(findViewById(R.id.textView1))
        listTextView.add(findViewById(R.id.textView2))
        listTextView.add(findViewById(R.id.textView3))
        listTextView.add(findViewById(R.id.textView4))
        listTextView.add(findViewById(R.id.textView5))
        listTextView.add(findViewById(R.id.textView6))
        listTextView.add(findViewById(R.id.textView7))
        listTextView.add(findViewById(R.id.textView8))
        listTextView.add(findViewById(R.id.textView9))
        listTextView.add(findViewById(R.id.textView10))
        Log.d(LOG_TAG, "Finished")
        if (savedInstanceState != null) {
            for(i in 0..9) {
                val isVisible = savedInstanceState.getBoolean("reply_visible $i")
                if (isVisible) {
                    listTextView[i].visibility = View.VISIBLE
                    listTextView[i].text = savedInstanceState.getString("reply_text $i")
                    items.add(savedInstanceState.getString("reply_text $i") ?: "Error")
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        for (i in 0 until items.size) {
            if (listTextView[i].visibility == View.VISIBLE) {
                outState.putBoolean("reply_visible $i", true);
                outState.putString("reply_text $i", listTextView[i].text.toString());
            }
        }
    }

    fun addProduct(view: View) {
        intent = Intent(this, SecondActivity::class.java)
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
                if(items.size < 10) {
                    items.add(reply ?: "Error")
                } else {
                    items.removeFirst()
                    items.add(reply ?: "Error")
                }
                Log.d(LOG_TAG, "Size: ${items.size}")
                Log.d(LOG_TAG, "Size: ${listTextView.size}")
                for(i in 0 until items.size) {
                    listTextView[i].visibility = View.VISIBLE
                    listTextView[i].text = items[i]
                }
            }
        }
    }
}