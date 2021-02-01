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

public class SaidasRegenerativo extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView res_trabalho, res_rendimento, res_titulo, res_calor, res_titulo_dois;
    private TextView txt_pressao_um, txt_temperatura_um, txt_entalpia_um, txt_entropia_um;
    private TextView txt_pressao_dois, txt_temperatura_dois, txt_entalpia_dois, txt_entropia_dois;
    private TextView txt_pressao_tres, txt_temperatura_tres, txt_entalpia_tres, txt_entropia_tres;
    private TextView txt_pressao_quatro, txt_temperatura_quatro, txt_entalpia_quatro, txt_entropia_quatro;
    private TextView txt_pressao_cinco, txt_temperatura_cinco, txt_entalpia_cinco, txt_entropia_cinco;
    private TextView txt_pressao_seis, txt_temperatura_seis, txt_entalpia_seis, txt_entropia_seis;
    private TextView txt_pressao_sete, txt_temperatura_sete, txt_entalpia_sete, txt_entropia_sete;
    private static final String TAG = "SaidasRegenerativo";
    private Boolean x6_superaquecido, x7_superaquecido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saidas_regenerativo);

        toolbar = findViewById(R.id.toolbar);

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

        //Passar dados
        Bundle dados = getIntent().getExtras();

        float p_baixa = dados.getFloat("p_baixa");
        float p_intermediaria = dados.getFloat("p_intermediaria");
        float p_alta = dados.getFloat("p_alta");
        float temperatura = dados.getFloat("temperatura");


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

        txt_pressao_sete = findViewById(R.id.txt_pressao_sete);
        txt_temperatura_sete = findViewById(R.id.txt_temperatura_sete);
        txt_entalpia_sete = findViewById(R.id.txt_entalpia_sete);
        txt_entropia_sete = findViewById(R.id.txt_entropia_sete);

        String fluido = "Water";
        float p1 =  1000*p_baixa;
        Log.d(TAG, "p1 " + p1);
        float p3 =  1000*p_intermediaria;
        Log.d(TAG, "p3 " + p3);
        float p5 =  1000*p_alta;
        Log.d(TAG, "p5 " + p5);
        float t5;
        if (temperatura == -1) {
            t5 = (float) CoolProp.PropsSI("T", "P|gas", p5, "Q", 1, fluido);
        } else {
            t5 = temperatura + 273.15f;
        }

        rankine_regenerativo(p1,p3,p5,t5,fluido);

    }

    void rankine_regenerativo(float p1, float p3, float p5, float t5, String fluido){
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




        //Estado 1
        float h1 = (float) CoolProp.PropsSI("H", "P|liquid", p1, "Q", 0, fluido); //Entalpia 1
        txt_entalpia_um.setText(entalpia + String.format("%.2f", h1 / 1000) + kj_kg);

        float s1 = (float) CoolProp.PropsSI("S", "P|liquid", p1, "Q", 0, fluido); //Entropia 1
        txt_entropia_um.setText(entropia + String.format("%.2f", s1 / 1000) + kj_kgk);

        txt_pressao_um.setText(pressao + String.format("%.2f", p1 / 1000) + kpa);

        float t1 = (float) CoolProp.PropsSI("T","P|liquid", p1, "Q", 0, fluido);
        txt_temperatura_um.setText(temp + String.format("%.2f", t1 - 273.15f) + celsius);

        //Estado 2
        float p2 = p3; //Compressão
        txt_pressao_dois.setText(pressao + String.format("%.2f", p2 / 1000) + kpa);

        float s2 = s1; //Processo Isoentrópico
        txt_entropia_dois.setText(entropia + String.format("%.2f", s2 / 1000) + kj_kgk);

        float h2 = (float) CoolProp.PropsSI("H", "P|liquid", p2, "S", s2, fluido); //Entalpia 2
        txt_entalpia_dois.setText(entalpia + String.format("%.2f", h2 / 1000) + kj_kg);

        float t2 = (float) CoolProp.PropsSI("T", "P|liquid", p2, "S", s2, fluido);
        txt_temperatura_dois.setText(temp + String.format("%.2f", t2 - 273.15f) + celsius);

        //Estado 3
        float h3 = (float) CoolProp.PropsSI("H", "P|liquid", p3, "Q", 0, fluido); //Entalpia 3
        txt_entalpia_tres.setText(entalpia + String.format("%.2f", (h3 / 1000)) + kj_kg);

        float s3 = (float) CoolProp.PropsSI("S", "P|liquid", p3, "Q", 0, fluido); //Entropia 3
        txt_entropia_tres.setText(entropia + String.format("%.2f", (s3 / 1000)) + kj_kgk);
        txt_pressao_tres.setText(pressao + String.format("%.2f", (p3 / 1000)) + kpa);

        float t3 = (float) CoolProp.PropsSI("T", "P|liquid", p3, "Q", 0, fluido);
        txt_temperatura_tres.setText(temp + String.format("%.2f", (t3 - 273.15f)) + celsius);

        //Estado 4
        float s4 = s3;
        txt_entropia_quatro.setText(entropia + String.format("%.2f", s4 / 1000) + kj_kgk);

        float p4 = p5;
        txt_pressao_quatro.setText(pressao + String.format("%.2f", p4 / 1000) + kpa);

        float h4 = (float) CoolProp.PropsSI("H", "P|liquid", p4, "S", s4, fluido);
        txt_entalpia_quatro.setText(entalpia + String.format("%.2f", (h4 / 1000)) + kj_kg);

        float t4 = (float) CoolProp.PropsSI("T", "P|liquid", p4, "S", s4, fluido);
        txt_temperatura_quatro.setText(temp + String.format("%.2f", t4 - 273.15f) + celsius);

        //Estado 5
        float h5 = (float) CoolProp.PropsSI("H", "P|gas", p5, "T", t5, fluido);
        Log.d(TAG, "p5 :" + p5);
        Log.d(TAG, "t5 :" + t5);
        Log.d(TAG, "h5 :" + h5);
        txt_entalpia_cinco.setText(entalpia + String.format("%.2f", h5 / 1000) + kj_kg);

        float s5 = (float) CoolProp.PropsSI("S", "P|gas", p5, "T", t5, fluido);
        txt_entropia_cinco.setText(entropia + String.format("%.2f", s5 / 1000)  + kj_kgk);
        Log.d(TAG, "s5 :" + s5);

        txt_temperatura_cinco.setText(temp + String.format("%.2f", t5 - 273.15) + celsius );

        txt_pressao_cinco.setText(pressao + String.format("%.2f", p5 / 1000) + kpa);

        //Estado 6
        float p6 = p3;
        txt_pressao_seis.setText(pressao + String.format("%.2f", p6 / 1000) + kpa);

        float s6 = s5;
        txt_entropia_seis.setText(entropia + String.format("%.2f", s6 / 1000)  + kj_kgk);

        float h6 = (float) CoolProp.PropsSI("H", "P|gas", p6, "S", s6, fluido);
        txt_entalpia_seis.setText(entalpia + String.format("%.2f", h6 / 1000) + kj_kg);

        float t6 = (float) CoolProp.PropsSI("T", "P|gas", p6, "S", s6, fluido);
        txt_temperatura_seis.setText(temp + String.format("%.2f", t6 - 273.15) + celsius );

        //Para cálculo do título ponto 6:
        float s6l = (float) CoolProp.PropsSI("S", "P|gas", p6, "Q", 0, fluido);
        float s6v = (float) CoolProp.PropsSI("S", "P|gas", p6, "Q", 1, fluido);

        float x6 = (s6 - s6l) / (s6v - s6l);

        if (s6 > s6v) {
            x6_superaquecido = true;
        } else {
            x6_superaquecido = false;
        }

        //Estado 7
        float p7 = p1;
        txt_pressao_sete.setText(pressao + String.format("%.2f", p7/1000) + kpa);

        float s7 = s6;
        txt_entropia_sete.setText(entropia + String.format("%.2f", s7/1000) + kj_kgk);

        float h7 = (float) CoolProp.PropsSI("H", "P|gas", p7, "S", s7, fluido);
        txt_entalpia_sete.setText(entalpia + String.format("%.2f", h7/1000) + kj_kg);

        float t7 = (float) CoolProp.PropsSI("T", "P|gas", p7, "S", s7, fluido);
        txt_temperatura_sete.setText(temp + String.format("%.2f", t7 - 273.15) + celsius);

        //Para cálculo do título ponto 7:
        float s7l = (float) CoolProp.PropsSI("S", "P|gas", p7, "Q", 0, fluido);
        float s7v = (float) CoolProp.PropsSI("S", "P|gas", p7, "Q", 1, fluido);

        float x7 = (s7 - s7l) / (s7v - s7l);

        if (s7 > s7v) {
            x7_superaquecido = true;
        } else {
            x7_superaquecido = false;
        }

        //Fração mássica da extração
        float m = (h3 - h2)/( h6 - h2);

        //Parâmetros de Saída
        float wb1 = h2 - h1; //Trabalho na bomba 1
        float wb2 = h4 - h3; //Trabalho na bomba 2
        float wb = wb1 + wb2;
        float wt =  ((h5 - h6) + (1-m)*(h6 - h7)); //Trabalho na turbina
        float w = wt - wb;
        float qh =  (h5 - h4);  //Calor de Entrada
        float ql = (1-m)*(h7 - h1); //Calor rejeitado
        float n = (qh - ql)/qh; //Rendimento

        //Padronizando unidades
        h1 /= 1000;
        h2 /= 1000;
        h3 /= 1000;
        h4 /= 1000;
        h5 /= 1000;
        h6 /= 1000;
        h7 /= 1000;
        wt /= 1000;
        wb /= 1000;
        w /= 1000;
        qh /= 1000;
        ql /= 1000;
        x6 *= 100;
        x7 *= 100;
        n *= 100;
        m *= 100;


        res_trabalho.setText(String.format("%.2f", w) + kj_kg);
        res_rendimento.setText(String.format("%.2f", n) + por_cento);
        if (x6_superaquecido == true) {
            res_titulo.setText("Vapor superaquecido");
        } else {
            res_titulo.setText(String.format("%.2f", x6) + por_cento);
        }
        if (x7_superaquecido == true) {
            res_titulo_dois.setText("Vapor superaquecido");
        } else {
            res_titulo_dois.setText(String.format("%.2f", x7) + por_cento);
        }
        res_calor.setText(String.format("%.2f", qh) + kj_kg);
    }
}
