package com.pietrosales.ciclos_rankine;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaInicial extends AppCompatActivity {

    static {
        System.loadLibrary("CoolProp");
    }

    private Button potencia, calculadora, sobre;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo = findViewById(R.id.txt_titulo);
        potencia = findViewById(R.id.btn_potencia);
        calculadora = findViewById(R.id.btn_calculadora);
        sobre = findViewById(R.id.btn_sobre);

        potencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, TelaOpcoesRankine.class);
                startActivity(intent);
            }
        });

        calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, TelaCalculadora.class);
                startActivity(intent);
            }
        });

        sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, TelaSobre.class);
                startActivity(intent);
            }
        });

    }
}
