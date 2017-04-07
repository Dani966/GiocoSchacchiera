package com.example.danilocacace.giocoschacchiera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Danilo Cacace on 07/04/2017.
 */

public class Schacchiera extends View {

    private static int dimensione = 5;
    static boolean start = false;

    public Schacchiera(Context context) {
        super(context);
    }

    Paint paint = new Paint();

    public void onDraw(Canvas canvas){
        //Creo un "pennelo" fuori per rendere il più possibile leggero l'onDrar e creo un rettangolo delle dimensioni della View
        Rect sfondo = canvas.getClipBounds();

        //Mi definisco due variabili che identificano le dimensioni delle caselle
        int altezzaCasella = sfondo.height()/dimensione;
        int larghezzaCasella = sfondo.width()/dimensione;

        //Adesso devo colorarmi le caselle, in particolare devo distinguere due casi, uno per l'inizializzazione, ovvero la
        //Prima colorazione della scacchiera che servirà anche a far ripartire il gioco, mentre un ulteriore metodo servirà a
        //colorarla durante la fase di gioco all'inversione dei colori


    }
}

