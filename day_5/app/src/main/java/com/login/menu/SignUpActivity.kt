package com.login.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.password as password1
import kotlinx.android.synthetic.main.activity_sign_up.username1

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signup_btn.setOnClickListener{
            signUpUser()
        }
        button3.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun signUpUser() {

        auth = FirebaseAuth.getInstance()
        if (username1.text.toString().isEmpty()){
            username1.error="Please enter email"
            username1.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(username1.text.toString()).matches()){
            username1.error="Please enter email"
            username1.requestFocus()
            return
        }
        if(password.text.toString().isEmpty()){
            password.error="Please enter password"
            password.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(username1.text.toString(),password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser





                    user?.sendEmailVerification()?.addOnCompleteListener { task ->
                        if (task.isSuccessful) {

                            // Sign in success, update UI with the signed-in user's information
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()   }
                    }
                } else {

                    Toast.makeText(baseContext, "Signup failed. Try again after sometime"+task.exception,
                        Toast.LENGTH_SHORT).show()
                }
            }

    }
}
