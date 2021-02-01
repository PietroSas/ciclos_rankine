package com.pietrosales.ciclos_rankine.Saidas;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pietrosales.ciclos_rankine.CoolProp.CoolProp;
import com.pietrosales.ciclos_rankine.R;

public class SaidasSimples extends AppCompatActivity {



    private Toolbar toolbar;
    private TextView res_trabalho, res_rendimento, res_titulo, res_calor;
    private TextView txt_pressao_um, txt_temperatura_um, txt_entalpia_um, txt_entropia_um;
    private TextView txt_pressao_dois, txt_temperatura_dois, txt_entalpia_dois, txt_entropia_dois;
    private TextView txt_pressao_tres, txt_temperatura_tres, txt_entalpia_tres, txt_entropia_tres;
    private TextView txt_pressao_quatro, txt_temperatura_quatro, txt_entalpia_quatro, txt_entropia_quatro;
    private static final String TAG = "SaidasSimples";
    private Boolean x4_superaquecido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saidas_simples);

        toolbar = findViewById(R.id.toolbar);

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

        //Passar dados
        Bundle dados = getIntent().getExtras();

        Float p_baixa = dados.getFloat("p_baixa");
        Float p_alta = dados.getFloat("p_alta");
        Float temperatura = dados.getFloat("temperatura");

        //Encontrar TextViews
        res_trabalho = findViewById(R.id.res_trabalho);
        res_rendimento = findViewById(R.id.res_rendimento);
        res_titulo = findViewById(R.id.res_titulo);
        res_calor = findViewById(R.id.res_calor);

        txt_pressao_um = findViewById(R.id.txt_pressao_um);
        txt_temperatura_um = findViewById(R.id.txt_temperatura_um);
        txt_entalpia_um = findViewById(R.id.txt_pressao);
        txt_entropia_um = findViewById(R.id.txt_temperatura);

        txt_pressao_dois = findViewById(R.id.txt_entalpia);
        txt_temperatura_dois = findViewById(R.id.txt_entropia);
        txt_entalpia_dois = findViewById(R.id.txt_entalpia_dois);
        txt_entropia_dois = findViewById(R.id.txt_entropia_dois);

        txt_pressao_tres = findViewById(R.id.txt_pressao_tres);
        txt_temperatura_tres = findViewById(R.id.txt_temperatura_tres);
        txt_entalpia_tres = findViewById(R.id.txt_entalpia_tres);
        txt_entropia_tres = findViewById(R.id.txt_entropia_tres);

        txt_pressao_quatro = findViewById(R.id.txt_pressao_quatro);
        txt_temperatura_quatro = findViewById(R.id.txt_temperatura_quatro);
        txt_entalpia_quatro = findViewById(R.id.txt_entalpia_quatro);
        txt_entropia_quatro = findViewById(R.id.txt_entropia_quatro);



        //Dados de Entrada

        String kj_kg = " kJ/kg";
        String por_cento = " %";
        String kpa = " kPa";
        String kj_kgk = " kJ/(kg.K)";
        String celsius = " ºC";
        String pressao = "Pressão: ";
        String temp = "Temperatura: ";
        String entalpia = "Entalpia: ";
        String entropia = "Entropia: ";

        String fluido = "Water";
        float p1 =  1000*p_baixa;
        Log.d(TAG, "p1 " + p1);
        float p3 =  1000*p_alta;
        Log.d(TAG, "p3 " + p3);
        float t3;
        if (temperatura == -1) {
            t3 = (float) CoolProp.PropsSI("T", "P|gas", p3, "Q", 1, fluido);
        } else {
            t3 = temperatura + 273.15f;
        }


        //Estado 1
        float h1 = (float) CoolProp.PropsSI("H","P|liquid", p1, "Q", 0, fluido);
        txt_entalpia_um.setText(entalpia + String.format("%.2f", h1 / 1000) + kj_kg);
        Log.d(TAG, "h1 " + h1);
        float s1 = (float) CoolProp.PropsSI("S","P|liquid", p1, "Q", 0, fluido);
        txt_entropia_um.setText(entropia + String.format("%.2f", s1 / 1000) + kj_kgk);
        Log.d(TAG, "s1 " + s1);
        txt_pressao_um.setText(pressao + String.format("%.2f", p1 / 1000) + kpa);
        float t1 = (float) CoolProp.PropsSI("T","P|liquid", p1, "Q", 0, fluido);
        txt_temperatura_um.setText(temp + String.format("%.2f", t1 - 273.15f) + celsius);

        //Estado 2
        float p2 = p3;
        Log.d(TAG, "p2 " + p2);
        txt_pressao_dois.setText(pressao + String.format("%.2f", p2 / 1000) + kpa);
        float s2 = s1;
        Log.d(TAG, "s2 " + s2);
        txt_entropia_dois.setText(entropia + String.format("%.2f", s2 / 1000) + kj_kgk);
        float h2 = (float) CoolProp.PropsSI("H", "P|liquid", p2, "S", s2, fluido);
        Log.d(TAG, "h2 " + h2);
        txt_entalpia_dois.setText(entalpia + String.format("%.2f", h2 / 1000) + kj_kg);
        float t2 = (float) CoolProp.PropsSI("T", "P|liquid", p2, "S", s2, fluido);
        txt_temperatura_dois.setText(temp + String.format("%.2f", t2 - 273.15f) + celsius);

        //Estado 3
        float h3 = (float) CoolProp.PropsSI("H", "P|gas", p3, "T", t3, fluido);
        Log.d(TAG, "h3 " + h3);
        txt_entalpia_tres.setText(entalpia + String.format("%.2f", (h3 / 1000)) + kj_kg);
        float s3 = (float) CoolProp.PropsSI("S", "P|gas", p3, "T", t3, fluido);
        Log.d(TAG, "s3 " + s3);
        txt_entropia_tres.setText(entropia + String.format("%.2f", (s3 / 1000)) + kj_kgk);
        txt_pressao_tres.setText(pressao + String.format("%.2f", (p3 / 1000)) + kpa);
        txt_temperatura_tres.setText(temp + String.format("%.2f", (t3 - 273.15f)) + celsius);

        //Estado 4
        float s4 = s3;
        Log.d(TAG, "s4 " + s4);
        txt_entropia_quatro.setText(entropia + String.format("%.2f", s4 / 1000) + kj_kgk);
        float p4 = p1;
        Log.d(TAG, "p4 " + p4);
        txt_pressao_quatro.setText(pressao + String.format("%.2f", p4 / 1000) + kpa);
        float h4 = (float) CoolProp.PropsSI("H", "P|gas", p4, "S", s4, fluido);
        Log.d(TAG, "h4 " + h4);
        txt_entalpia_quatro.setText(entalpia + String.format("%.2f", (h4 / 1000)) + kj_kg);
        float t4 = (float) CoolProp.PropsSI("T", "P|gas", p4, "S", s4, fluido);
        txt_temperatura_quatro.setText(temp + String.format("%.2f", t4 - 273.15f) + celsius);

        //Para cálculo do título:
        float s4l = (float) CoolProp.PropsSI("S", "P|gas", p4, "Q", 0, fluido);
        Log.d(TAG, "s4l " + s4l);
        float s4v = (float) CoolProp.PropsSI("S", "P|gas", p4, "Q", 1, fluido);
        Log.d(TAG, "s4v " + s4v);
        float x4 = (s4 - s4l) / (s4v - s4l);
        if (s4 > s4v) {
            x4_superaquecido = true;
        } else {
            x4_superaquecido = false;
        }

        Log.d(TAG, "x4 " + x4);

        //Parâmetros de Saída
        float wb = h2 - h1; //Trabalho na bomba
        Log.d(TAG, "wb " + wb);
        float wt = h3 - h4; //Trabalho na turbina
        Log.d(TAG, "wt " + wt);
        float w = wt - wb; //Trabalho líquido
        Log.d(TAG, "w " + w);
        float qh = h3 - h2; //Calor de Entrada
        Log.d(TAG, "qh " + qh);
        float ql = h4 - h1; //Calor rejeitado
        Log.d(TAG, "ql " + ql);
        float n = (qh - ql)/qh; //Rendimento
        Log.d(TAG, "n " + n);


        //Padronizando unidades
        h1 /= 1000;
        h2 /= 1000;
        h3 /= 1000;
        h4 /= 1000;
        wt /= 1000;
        wb /= 1000;
        w /= 1000;
        qh /= 1000;
        ql /= 1000;
        x4 *= 100;
        n *= 100;

        res_trabalho.setText(String.format("%.2f", w) + kj_kg);
        res_rendimento.setText(String.format("%.2f", n) + por_cento);
        if (x4_superaquecido == true) {
            res_titulo.setText("Vapor superaquecido");
        } else {
            res_titulo.setText(String.format("%.2f", x4) + por_cento);
        }
        res_calor.setText(String.format("%.2f", qh) + kj_kg);


    }
}
