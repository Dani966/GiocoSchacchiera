package com.example.danilocacace.giocoschacchiera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button mPulsante;
    Schacchiera mScacchiera;
    EditText mDimensione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPulsante = (Button) findViewById(R.id.restart);
        mScacchiera = (Schacchiera) findViewById(R.id.scacchiera);

        mPulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScacchiera.restart();
            }
        });
    }
}
