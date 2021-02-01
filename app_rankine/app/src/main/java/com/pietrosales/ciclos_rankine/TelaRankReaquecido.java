package com.pietrosales.ciclos_rankine;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pietrosales.ciclos_rankine.Entradas.TelaResultadosReaquecido;

public class TelaRankReaquecido extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView arranjo;
    private TextView diagrama;
    private Button dimensionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_rank_reaquecido);

        toolbar = findViewById(R.id.toolbar_rankine);
        dimensionar = findViewById(R.id.btn_dimensionar);

        toolbar.setTitle("Rankine Reaquecido");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        dimensionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaRankReaquecido.this, TelaResultadosReaquecido.class);
                startActivity(intent);
            }
        });

    }
}
