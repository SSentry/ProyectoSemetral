package com.example.proyectosemetral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    // CREO LAS VARIABLES DE TIPO BOTON
    Button SANDWICHES;
    Button SOBRE_NOSOTROS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // le asigno  LA ID de la interfaz
        SANDWICHES = findViewById(R.id.button);
        SOBRE_NOSOTROS= findViewById(R.id.button2);


        // En caso de Presionar el boton SANWICHES , ME DIRECCIONA AL ACTIVITY Sandwiches.class
        SANDWICHES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Inicio.this , Sandwiches.class);
                startActivity(next);

            }
        });

        // En caso de Presionar el boton SOBRE_NOSOTROS , ME DIRECCIONA EL ACTIVITY A
        SOBRE_NOSOTROS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Inicio.this , AcercaNosotros.class);
                startActivity(next);

            }
        });
    }
}
