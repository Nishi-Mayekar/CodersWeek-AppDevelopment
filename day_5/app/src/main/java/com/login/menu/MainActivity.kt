package com.login.menu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        signOutButton.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
        }
        location.setOnClickListener {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }
        counter_btn.setOnClickListener {
            Toast.makeText(this, "Starting counter", Toast.LENGTH_LONG).show()
            val intent = Intent(this, CounterActivity::class.java)
            startActivity(intent)
        }
        calci_btn.setOnClickListener {
            val intent = Intent(this, Calculator::class.java)
            startActivity(intent)
        }
    }
}
