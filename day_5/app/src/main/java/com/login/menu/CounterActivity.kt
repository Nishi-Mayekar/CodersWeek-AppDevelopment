package com.login.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_counter.*

class CounterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        var count = 0

        textView

        button.setOnClickListener{
            count++
            textView.text = "You clicked $count times"
        }
        button2.setOnClickListener{
            count = 0
            textView.text = "You clicked $count times"
        }

    }
}
