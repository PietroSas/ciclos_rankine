package com.pietrosales.ciclos_rankine;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pietrosales.ciclos_rankine.Entradas.TelaResultadosSimples;

public class TelaRankSimples extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;
    private TextView arranjo;
    private TextView diagrama;
    private Button dimensionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_rank_simples);

        toolbar = findViewById(R.id.toolbar_rankine);
        dimensionar = findViewById(R.id.btn_dimensionar);

        toolbar.setTitle("Rankine Simples");
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
                Intent intent = new Intent(TelaRankSimples.this, TelaResultadosSimples.class);
                startActivity(intent);
            }
        });




    }
}
