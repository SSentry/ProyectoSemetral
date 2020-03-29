package com.example.proyectosemetral;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AcercaNosotros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_nosotros);

        // vuelvo visible el boton volver atras del appbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        // metodo para volver atras
        onBackPressed();

        return true;
    }
}
