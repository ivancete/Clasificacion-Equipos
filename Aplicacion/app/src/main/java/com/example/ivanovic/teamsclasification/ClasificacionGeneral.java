package com.example.ivanovic.teamsclasification;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ClasificacionGeneral extends Activity {

    private Document doc;
    public static ArrayList<ArrayList<String>> equiposEspania;
    public static ArrayList<ArrayList<String>> equiposInglaterra;
    public static ArrayList<ArrayList<String>> equiposItalia;
    public static ArrayList<ArrayList<String>> equiposFrancia;
    public static ArrayList<ArrayList<String>> equiposAlemania;
    private Button clasificacionEspania;
    private Button clasificacionInglaterra;
    private Button clasificacionItalia;
    private Button clasificacionFrancia;
    private Button clasificacionAlemania;
    private AsyncTask<Void, Integer, Void> tarea1;
    private AsyncTask<Void, Integer, Void> tarea2;
    private AsyncTask<Void, Integer, Void> tarea3;
    private AsyncTask<Void, Integer, Void> tarea4;
    private AsyncTask<Void, Integer, Void> tarea5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        equiposEspania = new ArrayList<ArrayList<String> >();
        equiposInglaterra = new ArrayList<ArrayList<String> >();
        equiposItalia = new ArrayList<ArrayList<String> >();
        equiposFrancia = new ArrayList<ArrayList<String> >();
        equiposAlemania = new ArrayList<ArrayList<String> >();

        clasificacionEspania = (Button) findViewById(R.id.clasificacionEspania);
        clasificacionEspania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lanzarClasificacionEspania(null);
            }
        });

        clasificacionInglaterra = (Button) findViewById(R.id.clasificacionInglaterra);
        clasificacionInglaterra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lanzarClasificacionInglaterra(null);
            }
        });

        clasificacionItalia = (Button) findViewById(R.id.clasificacionItalia);
        clasificacionItalia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lanzarClasificacionItalia(null);
            }
        });

        clasificacionFrancia = (Button) findViewById(R.id.clasificacionFrancia);
        clasificacionFrancia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lanzarClasificacionFrancia(null);
            }
        });

        clasificacionAlemania = (Button) findViewById(R.id.clasificacionAlemania);
        clasificacionAlemania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lanzarClasificacionAlemania(null);
            }
        });
    }

    private class FindTeamsSpain extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {
                //Necesitará protocolo http
                doc = Jsoup.connect("http://resultados.as.com/resultados/futbol/primera/clasificacion/").get();

                Elements tabla = doc.select("table[class=\"tabla-datos table-hover\"]");

                Elements cuerpoTabla = tabla.select("tbody");

                Elements miniTabla = tabla.select("span[class=\"nombre-equipo\"]");

                String otro;

                ArrayList<String> equipo = new ArrayList<String>();

                for (Element e : miniTabla) {

                    otro = Jsoup.parse(e.toString()).text();

                    equipo.add(otro);

                    equiposEspania.add(new ArrayList<String>(equipo));

                    equipo.remove(0);
                }

                Elements puntuacion = cuerpoTabla.select("tr");

                Element eAuxiliar;

                Elements auxiliar;

                int i = 0;

                String pnts;

                for (Element e : puntuacion) {

                    auxiliar = e.select("td");

                    for (int j = 0; j < 7; j++) {

                        eAuxiliar = auxiliar.get(j);

                        pnts = Jsoup.parse(eAuxiliar.toString()).text();

                        equiposEspania.get(i).add(pnts);
                    }

                    i++;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

            this.cancel(true);

            return null;
        }
    }

    private class FindTeamsEngland extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {
                //Necesitará protocolo http
                doc = Jsoup.connect("http://resultados.as.com/resultados/futbol/inglaterra/clasificacion").get();

                Elements tabla = doc.select("table[class=\"tabla-datos table-hover\"]");

                Elements cuerpoTabla = tabla.select("tbody");

                Elements miniTabla = tabla.select("span[class=\"nombre-equipo\"]");

                String otro;

                ArrayList<String> equipo = new ArrayList<String>();

                for (Element e : miniTabla) {

                    otro = Jsoup.parse(e.toString()).text();

                    equipo.add(otro);

                    equiposInglaterra.add(new ArrayList<String>(equipo));

                    equipo.remove(0);
                }

                Elements puntuacion = cuerpoTabla.select("tr");

                Element eAuxiliar;

                Elements auxiliar;

                int i = 0;

                String pnts;

                for (Element e : puntuacion) {

                    auxiliar = e.select("td");

                    for (int j = 0; j < 7; j++) {

                        eAuxiliar = auxiliar.get(j);

                        pnts = Jsoup.parse(eAuxiliar.toString()).text();

                        equiposInglaterra.get(i).add(pnts);
                    }

                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            this.cancel(true);

            return null;
        }
    }

    private class FindTeamsItaly extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {
                //Necesitará protocolo http
                doc = Jsoup.connect("http://resultados.as.com/resultados/futbol/italia/clasificacion/").get();

                Elements tabla = doc.select("table[class=\"tabla-datos table-hover\"]");

                Elements cuerpoTabla = tabla.select("tbody");

                Elements miniTabla = tabla.select("span[class=\"nombre-equipo\"]");

                String otro;

                ArrayList<String> equipo = new ArrayList<String>();

                for (Element e : miniTabla) {

                    otro = Jsoup.parse(e.toString()).text();

                    equipo.add(otro);

                    equiposItalia.add(new ArrayList<String>(equipo));

                    equipo.remove(0);
                }

                Elements puntuacion = cuerpoTabla.select("tr");

                Element eAuxiliar;

                Elements auxiliar;

                int i = 0;

                String pnts;

                for (Element e : puntuacion) {

                    auxiliar = e.select("td");

                    for (int j = 0; j < 7; j++) {

                        eAuxiliar = auxiliar.get(j);

                        pnts = Jsoup.parse(eAuxiliar.toString()).text();

                        equiposItalia.get(i).add(pnts);
                    }

                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            this.cancel(true);

            return null;
        }
    }

    private class FindTeamsFrance extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {
                //Necesitará protocolo http
                doc = Jsoup.connect("http://resultados.as.com/resultados/futbol/francia/clasificacion/").get();

                Elements tabla = doc.select("table[class=\"tabla-datos table-hover\"]");

                Elements cuerpoTabla = tabla.select("tbody");

                Elements miniTabla = tabla.select("span[class=\"nombre-equipo\"]");

                String otro;

                ArrayList<String> equipo = new ArrayList<String>();

                for (Element e : miniTabla) {

                    otro = Jsoup.parse(e.toString()).text();

                    equipo.add(otro);

                    equiposFrancia.add(new ArrayList<String>(equipo));

                    equipo.remove(0);
                }

                Elements puntuacion = cuerpoTabla.select("tr");

                Element eAuxiliar;

                Elements auxiliar;

                int i = 0;

                String pnts;

                for (Element e : puntuacion) {

                    auxiliar = e.select("td");

                    for (int j = 0; j < 7; j++) {

                        eAuxiliar = auxiliar.get(j);

                        pnts = Jsoup.parse(eAuxiliar.toString()).text();

                        equiposFrancia.get(i).add(pnts);
                    }

                    i++;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

            this.cancel(true);

            return null;
        }
    }

    private class FindTeamsGermany extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {
                //Necesitará protocolo http
                doc = Jsoup.connect("http://resultados.as.com/resultados/futbol/alemania/clasificacion/").get();

                Elements tabla = doc.select("table[class=\"tabla-datos table-hover\"]");

                Elements cuerpoTabla = tabla.select("tbody");

                Elements miniTabla = tabla.select("span[class=\"nombre-equipo\"]");

                String otro;

                ArrayList<String> equipo = new ArrayList<String>();

                for (Element e : miniTabla) {

                    otro = Jsoup.parse(e.toString()).text();

                    equipo.add(otro);

                    equiposAlemania.add(new ArrayList<String>(equipo));

                    equipo.remove(0);
                }

                Elements puntuacion = cuerpoTabla.select("tr");

                Element eAuxiliar;

                Elements auxiliar;

                int i = 0;

                String pnts;

                for (Element e : puntuacion) {

                    auxiliar = e.select("td");

                    for (int j = 0; j < 7; j++) {

                        eAuxiliar = auxiliar.get(j);

                        pnts = Jsoup.parse(eAuxiliar.toString()).text();

                        equiposAlemania.get(i).add(pnts);
                    }

                    i++;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

            this.cancel(true);

            return null;
        }
    }

    public void lanzarClasificacionEspania(View view){
        Intent k = new Intent(this, ClasificacionEspania.class);


        if(equiposEspania.size() == 0) {
            tarea1 = new FindTeamsSpain();
            tarea1.execute();

            while(!tarea1.isCancelled()){
            }
        }

        startActivity(k);
    }

    public void lanzarClasificacionInglaterra(View view){

        Intent k = new Intent(this, ClasificacionInglaterra.class);

        if(equiposInglaterra.size() == 0) {
            tarea2 = new FindTeamsEngland();
            tarea2.execute();

            while(!tarea2.isCancelled()){
            }
        }

        startActivity(k);
    }

    public void lanzarClasificacionItalia(View view){

        Intent k = new Intent(this, ClasificacionItalia.class);

        if(equiposItalia.size() == 0) {
            tarea3 = new FindTeamsItaly();
            tarea3.execute();

            while(!tarea3.isCancelled()){
            }
        }

        startActivity(k);
    }

    public void lanzarClasificacionFrancia(View view){

        Intent k = new Intent(this, ClasificacionFrancia.class);

        if(equiposFrancia.size() == 0) {
            tarea4 = new FindTeamsFrance();
            tarea4.execute();

            while(!tarea4.isCancelled()){
            }
        }

        startActivity(k);
    }

    public void lanzarClasificacionAlemania(View view){

        Intent k = new Intent(this, ClasificacionAlemania.class);

        if(equiposAlemania.size() == 0) {
            tarea5 = new FindTeamsGermany();
            tarea5.execute();

            while(!tarea5.isCancelled()){
            }
        }

        startActivity(k);
    }
}

