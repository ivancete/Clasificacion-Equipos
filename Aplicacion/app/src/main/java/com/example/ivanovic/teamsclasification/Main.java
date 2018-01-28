package com.example.ivanovic.teamsclasification;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {
    private Button clasificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.inicio);

        clasificacion = (Button) findViewById(R.id.clasificacion);
        clasificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lanzarClasificacion(null);
            }
        });

    }

    public void lanzarClasificacion(View view){
        Intent i = new Intent(this, ClasificacionGeneral.class);

        startActivity(i);
    }
}
