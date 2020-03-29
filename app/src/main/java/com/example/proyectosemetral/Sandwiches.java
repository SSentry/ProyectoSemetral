package com.example.proyectosemetral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import java.util.ArrayList;

public class Sandwiches extends AppCompatActivity {

    LinearLayout contenedor;
    String nombre_italiano, nombre_chacarero,nombre_barrosluco,nombre_mechado,nombre_avepalta;
    String descripcion_italiano,descripcion_chacarero,descripcion_barrosluco,descripcion_mechado,descripcion_avepalta;
    String precio_italiano , precio_chacarero,precio_barrosluco,precio_mechado,precio_avepalta;
    String identificador_italiano,identificador_chacarero,identificador_barrosluco,identificador_mechado,identificador_avepalta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwiches);
        contenedor = (LinearLayout) findViewById(R.id.contenedor);

        String titulo = getString(R.string.sandwichess);
        // LE AGREGO EL NOMBRE AL APPBAR Y LO HAGO VISIBLE
        this.setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // le asigno los nombres  desde el archivo String.xml a las variables
        nombre_italiano=getString(R.string.NOMBRE_ITALIANO);
        nombre_chacarero=getString(R.string.NOMBRE_CHACARERO);
        nombre_barrosluco=getString(R.string.NOMBRE_BARROS_LUCO);
        nombre_mechado=getString(R.string.NOMBRE_MECHADO);
        nombre_avepalta=getString(R.string.NOMBRE_AVE_PALTA);

        // Le Asigno la descripcion desde el archivo String.xml a las variables
        descripcion_italiano=getString(R.string.DESCRIPCION_ITALIANO);
        descripcion_chacarero=getString(R.string.DESCRIPCION_CHACARERO);
        descripcion_barrosluco=getString(R.string.DESCRIPCION_BARROS_LUCO);
        descripcion_mechado=getString(R.string.DESCRIPCION_MECHADO);
        descripcion_avepalta=getString(R.string.DESCRIPCION_AVE_FALTA);

        // le asigno el precio de los sandwhich desde el archivo String.xml

        precio_italiano=getString(R.string.PRECIO_ITALIANO);
        precio_chacarero=getString(R.string.PRECIO_CHACARERO);
        precio_barrosluco=getString(R.string.PRECIO_BARROS_LUCO);
        precio_mechado=getString(R.string.PRECIO_MECHADO);
        precio_avepalta=getString(R.string.PRECIO_AVE_PALTA);

        // le asigno el identificador de la imagen de los sandwich desde el archivo String.xml

        identificador_italiano=getString(R.string.IDENTIFICADOR_ITALIANO);
        identificador_chacarero=getString(R.string.IDENTIFICADOR_CHACARERO);
        identificador_barrosluco=getString(R.string.IDENTIFICADOR_BARROS_LUCO);
        identificador_mechado=getString(R.string.IDENTIFICADOR_MECHADO);
        identificador_avepalta=getString(R.string.IDENTIFICADOR_AVE_PALTA);




        // CREO UN ARRAY LIST DE EL OBJETO Sandwich , Y INGRESO LOS PARAMETROS
        ArrayList<Sandwich> lista = new ArrayList<Sandwich>();
        lista.add(new Sandwich(1,nombre_italiano,descripcion_italiano,precio_italiano,identificador_italiano));
        lista.add(new Sandwich(2,nombre_chacarero,descripcion_chacarero,precio_chacarero,identificador_chacarero));
        lista.add(new Sandwich(3,nombre_barrosluco,descripcion_barrosluco,precio_barrosluco,identificador_barrosluco));
        lista.add(new Sandwich(4,nombre_mechado,descripcion_mechado,precio_mechado,identificador_mechado));
        lista.add(new Sandwich(5,nombre_avepalta,descripcion_avepalta,precio_avepalta,identificador_avepalta));



        Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(),R.color.blanco);
        BitmapDrawable background = new BitmapDrawable(getResources(), bitmap);

        for (final Sandwich c:lista)
        {

            Log.i("infoo","se mete al for ");
            Button cb = new Button(getApplication());


            // INICIALIZO  LOS PARAMETROS PARA PODER DARLE MARGENES A LOS BOTONES
            LinearLayout.LayoutParams parametros = new LinearLayout.LayoutParams(
                    /*width*/ ViewGroup.LayoutParams.MATCH_PARENT,
                    /*height*/ ViewGroup.LayoutParams.WRAP_CONTENT

            );
            cb.setTextSize(25);
            //cb.setTextAppearance(R.style.boldText);
            cb.setTypeface(null, Typeface.BOLD);
            cb.setTextColor(getResources().getColor(R.color.blanco, null));
            cb.setBackgroundResource(PASTEL_COLORSS[0]);
            //le agrego los margenes al boton
            parametros.setMargins(30, 20,30, 50);
            cb.setLayoutParams(parametros);
            cb.setText(c.nombre);
            cb.setId(c.cod);
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("infoo","NOMBRE SANDWICH = "+c.nombre);
                    Log.i("infoo","Descripcion  SANDWICH= "+c.Descripcion);
                    Log.i("infoo","Precio SANDWICH= "+c.Precio);

                    // ENVIO LOS PARAMETROS AL ACTIVITY DetallleSandwich
                    Intent next = new Intent(Sandwiches.this , DetalleSandwich.class);
                    next.putExtra("NOMBRE",c.nombre);
                    next.putExtra("DESCRIPCION",c.Descripcion);
                    next.putExtra("PRECIO",c.Precio);
                    next.putExtra("IDENTIFICADOR",c.identificador_imagen);
                    startActivity(next);

                }
            });
            contenedor.addView(cb);
        }


    }

    // METODO PARA VOLVER ATRAS
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return true;
    }


// CREO UN METODO QUE TENDRA LOS COLORES QUE TENGO EN EL ARCHIVO COLORS.XML
    public static final int [] PASTEL_COLORSS={

            R.color.Amber

    };

}
