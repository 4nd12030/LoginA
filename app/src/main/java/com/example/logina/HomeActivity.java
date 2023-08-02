package com.example.logina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //TextView textEmail;
    ListView lista;
    List<String> androidVersionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //1. Conectar nuestro listView (Lista) al componente visual
        //   a travez del id
        lista = findViewById(R.id.listView);

        //2. Cargar la lista de elementos
        androidVersionList = new ArrayList<>();
        androidVersionList.add("Pie");
        androidVersionList.add("Oreo");
        androidVersionList.add("Nougat");
        androidVersionList.add("Lollipop");
        androidVersionList.add("Kitkat");
        androidVersionList.add("...");

        //3. Definir un Adaptador -> Tranforma el formato de lista en un listView(Pinta los valores en elementos visuales)

        ArrayAdapter adaptadorVersionesAndroid = new ArrayAdapter(
         //Para inicializar un objeto de tipo ArrayAdapter a que pasarle al constructor 3 parametros
                this,// Referencia al contexto,el activity en donde se va a lanzar
                android.R.layout.simple_list_item_1,//Hace referencia la template o layout que utilizaremos para mostrar los elementos de lalista
                //se inicia con android porque es una referencia a un fichero de android
                androidVersionList //Lista de elementos que queresmos cargar en el listView
        );

        // 4. Vinculacion del listview con el adaptador
        lista.setAdapter(adaptadorVersionesAndroid);

        //5. gestion de evento click
        lista.setOnItemClickListener(this);

        //Se crea un objeto tipo Bundle para optener el parametro del correo
        Bundle extras = getIntent().getExtras();
        String emailUsuario = extras.getString("valorEmail");
        setTitle(emailUsuario);

        /*textEmail = findViewById(R.id.textViewEmail);
        textEmail.setText("Bienvenido " + emailUsuario);*/
    }

    //5.1
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String androidVersion = androidVersionList.get(position);
        Log.i("APP", "Version click: "+androidVersion);


    }
}