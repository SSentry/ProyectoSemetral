package com.example.proyectosemetral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleSandwich extends AppCompatActivity {

    String nombre;
    String Precio;
    String Descripcion;
    String  identificador;
    int identi;

    TextView nombree;
    TextView descripcionn;
    TextView precioo;
    ImageView imagen;

    //  METODO QUE TIENE LAS IMAGENES DE LOS SANDWICH
    public static final int [] IMAGENES_SANDWICH={

                R.drawable.italiano,
                R.drawable.chacarero,
                R.drawable.barrosluco,
                R.drawable.mechado,
                  R.drawable.avepalta,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_sandwich);
        Intent intent = getIntent();


    // RECIBO LOS PARAMETROS QUE LLEGAN DESDE EL Activity Sandwiches
        nombre = intent.getStringExtra("NOMBRE");
        Descripcion=intent.getStringExtra("DESCRIPCION");
        Precio=intent.getStringExtra("PRECIO");
        identificador= intent.getStringExtra("IDENTIFICADOR");

        String titulo = getString(R.string.Detalle_SandWich);

        this.setTitle(titulo+" "+nombre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        identi = Integer. parseInt(identificador);


        nombree = findViewById(R.id.nombre);
        descripcionn= findViewById(R.id.descripcion);
        precioo = findViewById(R.id.precio);
        imagen= findViewById(R.id.imageView);

        imagen.setImageResource(IMAGENES_SANDWICH[identi]);
        nombree.setText("SANDWICH "+nombre);
        descripcionn.setText(Descripcion);
        precioo.setText("$ "+Precio);

        // mensajes de prueba
        Log.i("infoo","LLego Nombre = "+nombre);
        Log.i("infoo","LLego Descripcion = "+Descripcion);
        Log.i("infoo","LLego Precio = "+Precio);
        Log.i("infoo","LLego IDENTIFICADOR = "+identi);


    }

    // metodo para volver atras
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return true;
    }

}
