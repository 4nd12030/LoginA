package com.example.logina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSingIn : Button = findViewById(R.id.button_SignIn)
        btnSingIn.setOnClickListener(this)
       /* btnSingIn.setOnClickListener { view ->
            Toast.makeText(this, "Has iniciado sesion", Toast.LENGTH_LONG).show()
        }

        val btnSingup : Button = findViewById(R.id.button_SignUp)
        btnSingup.setOnClickListener { view ->
            Toast.makeText(this, "Vamos a crear tu cuenta", Toast.LENGTH_LONG).show()
        }*/

    }

    override fun onClick(p0: View?) {
        Log.i("APP", "Click en iniciar sesion")
        /* Java
        Intent intentLoging : new Intent(this, HomeActivity.class) startActivity(intentLoging);
         startActivity(intentLoging)*/

        // kotlin
        val editTextEmail : EditText = findViewById(R.id.editEmail)
        val editTextPassword : EditText= findViewById(R.id.editPassword)

        var email : String = editTextEmail.text.toString()
        var pass : String = editTextPassword.text.toString()


        if (email.isNotEmpty() && pass.isNotEmpty()) {
            val intentSingIn = Intent(this, HomeActivity::class.java)
            intentSingIn.putExtra("valorEmail", email)
            startActivity(intentSingIn)
        } else {
            when{
                email.isEmpty() && pass.isEmpty() -> {
                    editTextEmail.error = "Introduce tus datos!!"
                    editTextPassword.error = "Introduce tus datos!!"
                }
                email.isEmpty() -> editTextEmail.error = "Introduce tus datos!!"
                pass.isEmpty() -> editTextPassword.error = "Introduce tus datos!!"
            }

            //Toast.makeText(this, "Introduce tus datos!!", Toast.LENGTH_SHORT).show()
        }
    }
}