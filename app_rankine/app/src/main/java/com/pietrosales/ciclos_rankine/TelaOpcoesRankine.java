package com.pietrosales.ciclos_rankine;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class TelaOpcoesRankine extends AppCompatActivity {

    private Button simples;
    private Button reaquecimento;
    private Button regenerativo;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_opcoes_rankine);

        toolbar = findViewById(R.id.toolbar);

        simples = findViewById(R.id.btn_rank_simples);
        reaquecimento = findViewById(R.id.btn_rank_reaq);
        regenerativo = findViewById(R.id.btn_rank_reg);

        toolbar.setTitle("Ciclos Rankine");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        simples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaOpcoesRankine.this, TelaRankSimples.class);
                startActivity(intent);
            }
        });

        reaquecimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaOpcoesRankine.this, TelaRankReaquecido.class);
                startActivity(intent);
            }
        });

        regenerativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaOpcoesRankine.this, TelaRankRegenerativo.class);
                startActivity(intent);
            }
        });

    }
}
