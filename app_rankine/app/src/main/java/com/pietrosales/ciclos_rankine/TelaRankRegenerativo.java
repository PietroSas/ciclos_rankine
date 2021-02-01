package com.pietrosales.ciclos_rankine;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pietrosales.ciclos_rankine.Entradas.TelasResultadosRegenerativo;

public class TelaRankRegenerativo extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView arranjo;
    private TextView diagrama;
    private Button dimensionar;


    public TelaRankRegenerativo() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_rank_regenerativo);

        toolbar = findViewById(R.id.toolbar_rankine);
        dimensionar = findViewById(R.id.btn_dimensionar);


        toolbar.setTitle("Rankine Regenerativo");
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
                Intent intent = new Intent(TelaRankRegenerativo.this, TelasResultadosRegenerativo.class);
                startActivity(intent);
            }
        });

    }
}
