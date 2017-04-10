package com.example.danilocacace.giocoschacchiera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Danilo Cacace on 07/04/2017.
 */

public class Schacchiera extends View {

    private static int dimensione=8;
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
        //Creo un "pennelo" fuori per rendere il più possibile leggero l'onDraw e creo un rettangolo delle dimensioni della View
        Rect sfondo = canvas.getClipBounds();
        //Mi definisco due variabili che identificano le dimensioni delle caselle
        altezzaCasella = sfondo.height()/dimensione;
        larghezzaCasella = sfondo.width()/dimensione;


        //Disegno la scacchiera in base alla matrice d booleani
        for(int i=0; i<dimensione; i++){
            for (int j=0; j<dimensione;j++){
                if(scacchieraDati[i][j]==true){
                    Rect r = new Rect(sfondo.left+j*larghezzaCasella, sfondo.top+i*altezzaCasella, sfondo.left+(j+1)*larghezzaCasella, sfondo.top+(i+1)*altezzaCasella);
                    paint.setColor(Color.YELLOW);
                    canvas.drawRect(r,paint);
                }
                if(scacchieraDati[i][j]==false){
                    Rect r = new Rect(sfondo.left+j*larghezzaCasella, sfondo.top+i*altezzaCasella, sfondo.left+(j+1)*larghezzaCasella, sfondo.top+(i+1)*altezzaCasella);
                    paint.setColor(Color.BLACK);
                    canvas.drawRect(r,paint);
                }
            }
        }
    }

    public void restart(){
        startMatrice();
        this.invalidate();
    }
    public void startMatrice(){
        for(int i = 0; i<dimensione; i++){
            if(i%2==0){
                for(int j=0; j<dimensione; j++){
                    if(j%2 == 0){
                        scacchieraDati[i][j]=true;
                    }
                    if (j%2 != 0) {
                        scacchieraDati[i][j]=false;
                    }

                }
            }
            if(i%2 != 0){
                for(int j=0; j<dimensione; j++){
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

        int j = X/larghezzaCasella;
        int i = Y/altezzaCasella;
        Log.d("invertiMatrice", "i:"+i);
        Log.d("invertiMatrice", "j:"+j);

        for(int k=0; k<dimensione;k++){
            scacchieraDati[i][k]= !scacchieraDati[i][k];
        }
        for(int k=0; k<dimensione;k++){
            scacchieraDati[k][j]= !scacchieraDati[k][j];
        }
    }

    public boolean onTouchEvent (MotionEvent motionEvent){
        int azione = motionEvent.getAction();
        if(azione == motionEvent.ACTION_DOWN){
            x = motionEvent.getX();
            y = motionEvent.getY();
            Log.d("OnTouch", "X:"+x);
            Log.d("OnTouch", "Y:"+y);
            invertMatrice();
            this.invalidate();
            return true;
        }
        return false;
    }


}

