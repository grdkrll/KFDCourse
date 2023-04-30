package com.example.homeworkapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    private var count: TextView? = null
    private var textEdit: EditText? = null
    private var countValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        count = findViewById(R.id.count)
        textEdit = findViewById(R.id.editText)
        if (savedInstanceState != null) {
            countValue = savedInstanceState.getInt("count")
            count?.text = countValue.toString()
            textEdit?.setText(savedInstanceState.getString("textEdit"))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", countValue)
        outState.putString("textEdit", textEdit?.text.toString())
    }

    fun updateCount(view: View) {
        ++countValue
        count?.text = countValue.toString()
    }
}