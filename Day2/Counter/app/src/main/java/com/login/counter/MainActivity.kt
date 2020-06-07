package com.login.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //count of number for button clicks.

    var count=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textview = findViewById(R.id.textView) as TextView
        textview.text = "You clicked $count times"

    }

    fun onTap(view: View) {
        //increment count
        count++
        // locate textview and update label
        val textview = findViewById(R.id.textView) as TextView
        textview.text = "You clicked $count times"

              }

    fun onClick(view: View) {

        count=0
        val textview = findViewById(R.id.textView) as TextView
        textview.text = "You clicked $count times"

    }

}
