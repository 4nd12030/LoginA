package com.example.logina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Se crea un objeto tipo Bundle para optener el parametro del correo
        Bundle extras = getIntent().getExtras();
        String emailUsuario = extras.getString("valorEmail");

        textEmail = findViewById(R.id.textViewEmail);
        textEmail.setText("Bienvenido " + emailUsuario);



    }
}