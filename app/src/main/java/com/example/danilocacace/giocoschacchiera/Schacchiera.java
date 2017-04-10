package com.example.danilocacace.giocoschacchiera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Danilo Cacace on 07/04/2017.
 */

public class Schacchiera extends View {

    private static int dimensione = 5;
    static boolean start = false;
    static int altezzaCasella;
    static int larghezzaCasella;
    static float x;
    static float y;

    static boolean[][] scacchieraDati= new boolean[dimensione][dimensione];

    public Schacchiera(Context context) {
        super(context);
    }
    public Schacchiera(Context context, AttributeSet attributeSet){super (context, attributeSet);}

    Paint paint = new Paint();

    public void onDraw(Canvas canvas){
        //Creo un "pennelo" fuori per rendere il più possibile leggero l'onDrar e creo un rettangolo delle dimensioni della View
        Rect sfondo = canvas.getClipBounds();

        //Mi definisco due variabili che identificano le dimensioni delle caselle
        altezzaCasella = sfondo.height()/dimensione;
        larghezzaCasella = sfondo.width()/dimensione;


        //devo andare a cambiare i colori delle caselle toccate
        if(start==true){

        }



        //Adesso devo colorarmi le caselle, in particolare devo distinguere due casi, uno per l'inizializzazione, ovvero la
        //Prima colorazione della scacchiera che servirà anche a far ripartire il gioco, mentre un ulteriore metodo servirà a
        //colorarla durante la fase di gioco all'inversione dei colori
        if(start==false){
            for(int i = 0; i<=dimensione; i++){
                if(i%2==0){
                    for(int j=0; j<=dimensione; j++){
                        if(j%2 == 0){
                            paint.setColor(Color.YELLOW);
                            Rect r = new Rect(sfondo.left+j*larghezzaCasella, sfondo.top+i*altezzaCasella, sfondo.left+(j+1)*larghezzaCasella, sfondo.top+(i+1)*altezzaCasella);
                            canvas.drawRect(r, paint);
                        }
                        if (j%2 != 0) {
                            paint.setColor(Color.BLACK);
                            Rect r = new Rect(sfondo.left+j*larghezzaCasella, sfondo.top+i*altezzaCasella, sfondo.left+(j+1)*larghezzaCasella, sfondo.top+(i+1)*altezzaCasella);
                            canvas.drawRect(r,paint);
                        }

                     }
                }
                if(i%2 != 0){
                    for(int j=0; j<=dimensione; j++){
                        if(j%2 == 0){
                            paint.setColor(Color.BLACK);
                            Rect r = new Rect(sfondo.left+j*larghezzaCasella, sfondo.top+i*altezzaCasella, sfondo.left+(j+1)*larghezzaCasella, sfondo.top+(i+1)*altezzaCasella);
                            canvas.drawRect(r, paint);
                        }
                        if (j%2 != 0) {
                            paint.setColor(Color.YELLOW);
                            Rect r = new Rect(sfondo.left+j*larghezzaCasella, sfondo.top+i*altezzaCasella, sfondo.left+(j+1)*larghezzaCasella, sfondo.top+(i+1)*altezzaCasella);
                            canvas.drawRect(r, paint);
                        }

                    }
                }
            }
            start = true;
        }


    }

    public void restart(int dim){
        dimensione= dim;
        startMatrice(dim);
        start = false;
        this.invalidate();
    }
    public void startMatrice(int dimensione){
        for(int i = 0; i<=dimensione; i++){
            if(i%2==0){
                for(int j=0; j<=dimensione; j++){
                    if(j%2 == 0){
                        scacchieraDati[i][j]=true;
                    }
                    if (j%2 != 0) {
                        scacchieraDati[i][j]=false;
                    }

                }
            }
            if(i%2 != 0){
                for(int j=0; j<=dimensione; j++){
                    if(j%2 == 0){
                        scacchieraDati[i][j]=false;
                    }
                    if (j%2 != 0) {
                        scacchieraDati[i][j]=true;
                    }

                }
            }
        }
    }

    public void invertMatrice(){
        int X = (int)x;
        int Y = (int)y;

        int i = X/larghezzaCasella;
        int j = Y/altezzaCasella;

        for(int k=0; k<dimensione;k++){
            scacchieraDati[i][k]= !scacchieraDati[i][k];
        }
        for(int k=0; k<dimensione;k++){
            scacchieraDati[k][j]= !scacchieraDati[k][j];
        }
    }

    public boolean onTouchEvent (MotionEvent motionEvent){
        int azione = motionEvent.getAction();
        if(azione == motionEvent.ACTION_UP){
            x = motionEvent.getX();
            y = motionEvent.getY();
            invertMatrice();
            this.invalidate();
            return true;
        }
        return false;
    }


}

