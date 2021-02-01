package com.pietrosales.ciclos_rankine.Saidas;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pietrosales.ciclos_rankine.CoolProp.CoolProp;
import com.pietrosales.ciclos_rankine.R;

public class SaidasReaquecido extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView res_trabalho, res_rendimento, res_titulo, res_calor, res_titulo_dois;
    private TextView txt_pressao_um, txt_temperatura_um, txt_entalpia_um, txt_entropia_um;
    private TextView txt_pressao_dois, txt_temperatura_dois, txt_entalpia_dois, txt_entropia_dois;
    private TextView txt_pressao_tres, txt_temperatura_tres, txt_entalpia_tres, txt_entropia_tres;
    private TextView txt_pressao_quatro, txt_temperatura_quatro, txt_entalpia_quatro, txt_entropia_quatro;
    private TextView txt_pressao_cinco, txt_temperatura_cinco, txt_entalpia_cinco, txt_entropia_cinco;
    private TextView txt_pressao_seis, txt_temperatura_seis, txt_entalpia_seis, txt_entropia_seis;
    private static final String TAG = "SaidasReaquecido";
    private Boolean x4_superaquecido, x6_superaquecido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saidas_reaquecido);

        toolbar = findViewById(R.id.toolbar);

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

        //Passar dados
        Bundle dados = getIntent().getExtras();

        Float p_baixa = dados.getFloat("p_baixa");
        Float p_intermediaria = dados.getFloat("p_intermediaria");
        Float p_alta = dados.getFloat("p_alta");
        Float temperatura = dados.getFloat("temperatura");

        //Encontrar TextViews
        res_trabalho = findViewById(R.id.res_trabalho);
        res_rendimento = findViewById(R.id.res_rendimento);
        res_titulo = findViewById(R.id.res_titulo);
        res_titulo_dois = findViewById(R.id.res_titulo_dois);
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

        txt_pressao_cinco = findViewById(R.id.txt_pressao_cinco);
        txt_temperatura_cinco = findViewById(R.id.txt_temperatura_cinco);
        txt_entalpia_cinco = findViewById(R.id.txt_entalpia_cinco);
        txt_entropia_cinco = findViewById(R.id.txt_entropia_cinco);

        txt_pressao_seis = findViewById(R.id.txt_pressao_seis);
        txt_temperatura_seis = findViewById(R.id.txt_temperatura_seis);
        txt_entalpia_seis = findViewById(R.id.txt_entalpia_seis);
        txt_entropia_seis = findViewById(R.id.txt_entropia_seis);


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
        float p4 =  1000*p_intermediaria;
        Log.d(TAG, "p4 " + p4);
        float t3;
        if (temperatura == -1) {
            t3 = (float) CoolProp.PropsSI("T", "P|gas", p3, "Q", 1, fluido);
        } else {
            t3 = temperatura + 273.15f;
        }
        
        //Estado 1
        float h1 = (float) CoolProp.PropsSI("H", "P|liquid", p1, "Q", 0, fluido);
        txt_entalpia_um.setText(entalpia + String.format("%.2f", h1 / 1000) + kj_kg);
        float s1 = (float) CoolProp.PropsSI("S", "P|liquid", p1, "Q", 0, fluido) ;
        txt_entropia_um.setText(entropia + String.format("%.2f", s1 / 1000) + kj_kgk);
        txt_pressao_um.setText(pressao + String.format("%.2f", p1 / 1000) + kpa);
        float t1 = (float) CoolProp.PropsSI("T","P|liquid", p1, "Q", 0, fluido);
        txt_temperatura_um.setText(temp + String.format("%.2f", t1 - 273.15f) + celsius);
    
        //Estado 2
        float p2 = p3;
        txt_pressao_dois.setText(pressao + String.format("%.2f", p2 / 1000) + kpa);
        float s2 = s1;
        txt_entropia_dois.setText(entropia + String.format("%.2f", s2 / 1000) + kj_kgk);
        float h2 = (float) CoolProp.PropsSI("H", "P|liquid", p2, "S", s2, fluido);
        txt_entalpia_dois.setText(entalpia + String.format("%.2f", h2 / 1000) + kj_kg);
        float t2 = (float) CoolProp.PropsSI("T", "P|liquid", p2, "S", s2, fluido);
        txt_temperatura_dois.setText(temp + String.format("%.2f", t2 - 273.15f) + celsius);
        
        //Estado 3
        float h3 = (float) CoolProp.PropsSI("H", "P|gas", p3, "T", t3, fluido);
        txt_entalpia_tres.setText(entalpia + String.format("%.2f", (h3 / 1000)) + kj_kg);
        float s3 = (float) CoolProp.PropsSI("S", "P|gas", p3, "T", t3, fluido);
        txt_entropia_tres.setText(entropia + String.format("%.2f", (s3 / 1000)) + kj_kgk);
        txt_pressao_tres.setText(pressao + String.format("%.2f", (p3 / 1000)) + kpa);
        txt_temperatura_tres.setText(temp + String.format("%.2f", (t3 - 273.15f)) + celsius);
    
        //Estado 4
        float s4 = s3;
        txt_entropia_quatro.setText(entropia + String.format("%.2f", s4 / 1000) + kj_kgk);
        float h4 = (float) CoolProp.PropsSI("H", "P|gas", p4, "S", s4, fluido);
        txt_entalpia_quatro.setText(entalpia + String.format("%.2f", (h4 / 1000)) + kj_kg);
        float t4 = (float) CoolProp.PropsSI("T", "P|gas", p4, "S", s4, fluido);
        txt_temperatura_quatro.setText(temp + String.format("%.2f", t4 - 273.15f) + celsius);
        txt_pressao_quatro.setText(pressao + String.format("%.2f", p4 / 1000) + kpa);

        
        //Para cálculo do título:
        float s4l = (float) CoolProp.PropsSI("S", "P|gas", p4, "Q", 0, fluido);
        float s4v = (float) CoolProp.PropsSI("S", "P|gas", p4, "Q", 1, fluido);

        float x4 = (s4 - s4l) / (s4v - s4l);

        if (s4 > s4v) {
            x4_superaquecido = true;
        } else {
            x4_superaquecido = false;
        }
        
        //Estado 5
        float p5 = p4;
        txt_pressao_cinco.setText(pressao + String.format("%.2f", p5 / 1000) + kpa);
        float t5 = t3;
        txt_temperatura_cinco.setText(temp + String.format("%.2f", t5 - 273.15) + celsius );
        float h5 = (float) CoolProp.PropsSI("H", "P|gas", p5, "T", t5, fluido);
        txt_entalpia_cinco.setText(entalpia + String.format("%.2f", h5 / 1000) + kj_kg);
        float s5 = (float) CoolProp.PropsSI("S", "P|gas", p5, "T", t5, fluido);
        txt_entropia_cinco.setText(entropia + String.format("%.2f", s5 / 1000)  + kj_kgk);
    
        //Estado 6
        float s6 = s5;
        txt_entropia_seis.setText(entropia + String.format("%.2f", s6 / 1000)  + kj_kgk);
        float p6 = p1;
        txt_pressao_seis.setText(pressao + String.format("%.2f", p6 / 1000) + kpa);
        float h6 = (float) CoolProp.PropsSI("H", "P|gas", p6, "S", s6, fluido);
        txt_entalpia_seis.setText(entalpia + String.format("%.2f", h6 / 1000) + kj_kg);
        float t6 = (float) CoolProp.PropsSI("T", "P|gas", p6, "S", s6, fluido);
        txt_temperatura_seis.setText(temp + String.format("%.2f", t6 - 273.15) + celsius );
        
        //Para cálculo do título:
        float s6l = (float) CoolProp.PropsSI("S", "P|gas", p6, "Q", 0, fluido);
        float s6v = (float) CoolProp.PropsSI("S", "P|gas", p6, "Q", 1, fluido);

        float x6 = (s6 - s6l) / (s6v - s6l);

        if (s6 > s6v) {
            x6_superaquecido = true;
        } else {
            x6_superaquecido = false;
        }
    
        
        //Parâmetros de Saída
        float wb = h2 - h1;
        float wt1 = h3 - h4;
        float wt2 = h5 - h6;
        float wt = wt1 + wt2;
        float w = wt - wb;
        float qh = (h3 - h2) + (h5 - h4);
        float ql = h6 - h1;
        float n = (qh - ql)/qh;
        
        //Padronizando unidades
        h1 /= 1000;
        h2 /= 1000;
        h3 /= 1000;
        h4 /= 1000;
        h5 /= 1000;
        h6 /= 1000;
        wt1 /= 1000;
        wt2 /= 1000;
        wt /= 1000;
        wb /= 1000;
        w /= 1000;
        qh /= 1000;
        ql /= 1000;
        x4 *= 100;
        x6 *= 100;
        n *= 100;

        res_trabalho.setText(String.format("%.2f", w) + kj_kg);
        res_rendimento.setText(String.format("%.2f", n) + por_cento);
        if (x4_superaquecido == true) {
            res_titulo.setText("Vapor superaquecido");
        } else {
            res_titulo.setText(String.format("%.2f", x4) + por_cento);
        }
        if (x6_superaquecido == true) {
            res_titulo_dois.setText("Vapor superaquecido");
        } else {
            res_titulo_dois.setText(String.format("%.2f", x6) + por_cento);
        }
        res_calor.setText(String.format("%.2f", qh) + kj_kg);

    }
}
