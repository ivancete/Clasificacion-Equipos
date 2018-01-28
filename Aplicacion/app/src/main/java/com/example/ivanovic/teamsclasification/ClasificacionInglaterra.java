package com.example.ivanovic.teamsclasification;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.ivanovic.teamsclasification.ClasificacionGeneral.equiposInglaterra;

/**
 * Created by Ivanovic on 22/3/17.
 */

public class ClasificacionInglaterra extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.clasificacion_espania);

        TextView auxEquipo = (TextView) findViewById(R.id.equipo1);

        TextView auxPnts = (TextView) findViewById(R.id.pnts1);

        TextView auxPj = (TextView) findViewById(R.id.pj1);

        TextView auxPg = (TextView) findViewById(R.id.pg1);

        TextView auxPe = (TextView) findViewById(R.id.pe1);

        TextView auxPp = (TextView) findViewById(R.id.pp1);

        for(int i = 0; i < equiposInglaterra.size(); i++){
            auxEquipo.append(Integer.toString(i+1)+ " " +equiposInglaterra.get(i).get(0).toString()+"\n");
            auxPnts.append(equiposInglaterra.get(i).get(1).toString()+"\n");
            auxPj.append(equiposInglaterra.get(i).get(2).toString()+"\n");
            auxPg.append(equiposInglaterra.get(i).get(3).toString()+"\n");
            auxPe.append(equiposInglaterra.get(i).get(4).toString()+"\n");
            auxPp.append(equiposInglaterra.get(i).get(5).toString()+"\n");
        }
    }
}
