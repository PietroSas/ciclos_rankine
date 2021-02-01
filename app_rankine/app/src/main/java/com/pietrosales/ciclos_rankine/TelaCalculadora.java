package com.pietrosales.ciclos_rankine;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.pietrosales.ciclos_rankine.CoolProp.CoolProp;

public class TelaCalculadora extends AppCompatActivity {

    private Toolbar toolbar;
    private Spinner spinner_um, spinner_dois, spinner_fluido;
    private Button btn_calcular;
    private TextView txt_pressao, txt_temperatura, txt_entalpia, txt_entropia, txt_resultados, txt_energia_interna, txt_volume_especifico;
    private EditText edt_um, edt_dois;
    private double p, h, t, s, u, v_especifico;
    private String fluido;
    private static final String TAG = "TelaCalculadora";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calculadora);

        final String kj_kg = " kJ/kg";
        final String kpa = " kPa";
        final String kj_kgk = " kJ/(kg.K)";
        final String celsius = " ºC";
        final String m3_kg = " m³/kg";
        final String pressao = "Pressão\n";
        final String temperatura = "Temperatura\n ";
        final String entalpia = "Entalpia\n ";
        final String entropia = "Entropia\n ";
        final String energia_interna = "Energia Interna\n ";
        final String volume_especifico = "Volume Específico\n ";

        spinner_um = findViewById(R.id.spinner_propriedade_um);
        spinner_dois = findViewById(R.id.spinner_propriedade_dois);
        spinner_fluido = findViewById(R.id.spinner_fluido);

        edt_um = findViewById(R.id.edt_propriedade_um);
        edt_dois = findViewById(R.id.edt_propriedade_dois);
        btn_calcular = findViewById(R.id.btn_calcular);

        txt_entalpia = findViewById(R.id.txt_entalpia);
        txt_entropia = findViewById(R.id.txt_entropia);
        txt_pressao = findViewById(R.id.txt_pressao);
        txt_temperatura = findViewById(R.id.txt_temperatura);
        txt_resultados = findViewById(R.id.txt_resultados);
        txt_energia_interna = findViewById(R.id.txt_energia_interna);
        txt_volume_especifico = findViewById(R.id.txt_volume_especifico);


        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Calculadora de Propriedades");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.propriedades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_um.setAdapter(adapter);
        spinner_dois.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter_fluido = ArrayAdapter.createFromResource(this, R.array.fluidos, android.R.layout.simple_spinner_item);
        adapter_fluido.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_fluido.setAdapter(adapter_fluido);

        spinner_um.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (parent.getItemAtPosition(position).toString()){

                    case "Pressão (kPa)":
                    case "Temperatura (ºC)":
                    case "Entalpia (kJ/kg)":
                    case "Entropia (kJ/kg.K)":
                    case "Energia Interna (kJ/kg)":
                    case "Volume Específico (m³/kg)":
                        edt_um.setEnabled(true);
                        edt_um.setText("");
                        edt_um.setFocusableInTouchMode(true);
                        edt_um.setClickable(true);
                        break;

                    case "Líquido Saturado":
                        edt_um.setEnabled(false);
                        edt_um.setText("0");
                        edt_um.setFocusable(false);
                        edt_um.setClickable(false);
                        break;

                    case "Vapor Saturado":
                        edt_um.setEnabled(false);
                        edt_um.setText("1");
                        edt_um.setFocusable(false);
                        edt_um.setClickable(false);
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner_dois.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                switch (parent.getItemAtPosition(position).toString()) {

                    case "Pressão (kPa)":
                    case "Temperatura (ºC)":
                    case "Entalpia (kJ/kg)":
                    case "Entropia (kJ/kg.K)":
                    case "Energia Interna (kJ/kg)":
                    case "Volume Específico (m³/kg)":
                        edt_dois.setEnabled(true);
                        edt_dois.setText("");
                        edt_dois.setFocusableInTouchMode(true);
                        edt_dois.setClickable(true);
                        break;

                    case "Líquido Saturado":
                        edt_dois.setEnabled(false);
                        edt_dois.setText("0");
                        edt_dois.setFocusable(false);
                        edt_dois.setClickable(false);
                        break;

                    case "Vapor Saturado":
                        edt_dois.setEnabled(false);
                        edt_dois.setText("1");
                        edt_dois.setFocusable(false);
                        edt_dois.setClickable(false);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

            });



        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edt_um.onEditorAction(EditorInfo.IME_ACTION_DONE);
                edt_dois.onEditorAction(EditorInfo.IME_ACTION_DONE);

                String propriedade_um = spinner_um.getSelectedItem().toString();
                String propriedade_dois = spinner_dois.getSelectedItem().toString();

                fluido = spinner_fluido.getSelectedItem().toString();

                String valor_um = edt_um.getText().toString();
                String valor_dois = edt_dois.getText().toString();

                if (propriedade_um.equals(propriedade_dois)){
                    Toast.makeText(TelaCalculadora.this, "Selecione propriedades diferentes!", Toast.LENGTH_SHORT).show();
                } else {

                    if ( (valor_um.equals("") == false && valor_dois.equals("") == false ) ) {

                        String codigo_propriedade_um = codigo(propriedade_um);
                        String codigo_propriedade_dois = codigo(propriedade_dois);

                        double valor_um_double = Double.valueOf(valor_um);
                        double valor_dois_double = Double.valueOf(valor_dois);

                        if (codigo_propriedade_um == "T") {
                            valor_um_double += 273.15;
                        } else {
                            if (codigo_propriedade_um == "D") {
                                valor_um_double = 1/valor_um_double;
                            } else {
                                if (codigo_propriedade_um == "Q") {
                                    valor_um_double *= 1;
                                } else {
                                    valor_um_double *= 1000;
                                }
                            }
                        }

                        if (codigo_propriedade_dois == "T"){
                            valor_dois_double += 273.15;
                        } else {
                            if (codigo_propriedade_dois == "D") {
                                valor_dois_double = 1 / valor_dois_double;
                            } else {
                                if (codigo_propriedade_dois == "Q") {
                                    valor_dois_double *= 1;
                                } else {
                                    valor_dois_double *= 1000;
                                }
                            }
                        }

                        p = CoolProp.PropsSI("P", codigo_propriedade_um, valor_um_double, codigo_propriedade_dois, valor_dois_double, fluido);
                        t = CoolProp.PropsSI("T", codigo_propriedade_um, valor_um_double, codigo_propriedade_dois, valor_dois_double, fluido);
                        h = CoolProp.PropsSI("H", codigo_propriedade_um, valor_um_double, codigo_propriedade_dois, valor_dois_double, fluido);
                        s = CoolProp.PropsSI("S", codigo_propriedade_um, valor_um_double, codigo_propriedade_dois, valor_dois_double, fluido);
                        v_especifico = 1/(CoolProp.PropsSI("D", codigo_propriedade_um, valor_um_double, codigo_propriedade_dois, valor_dois_double, fluido));
                        u = CoolProp.PropsSI("U", codigo_propriedade_um, valor_um_double, codigo_propriedade_dois, valor_dois_double, fluido);

                        txt_pressao.setVisibility(View.VISIBLE);
                        txt_temperatura.setVisibility(View.VISIBLE);
                        txt_entalpia.setVisibility(View.VISIBLE);
                        txt_entropia.setVisibility(View.VISIBLE);
                        txt_resultados.setVisibility(View.VISIBLE);
                        txt_energia_interna.setVisibility(View.VISIBLE);
                        txt_volume_especifico.setVisibility(View.VISIBLE);


                        txt_pressao.setText(pressao + String.format("%.2f", p / 1000) + kpa);
                        txt_temperatura.setText(temperatura + String.format("%.2f", t - 273.15) + celsius );
                        txt_entalpia.setText(entalpia + String.format("%.2f", h / 1000) + kj_kg);
                        txt_entropia.setText(entropia + String.format("%.4f", s / 1000)  + kj_kgk);
                        txt_energia_interna.setText(energia_interna + String.format("%.2f", u / 1000) + kj_kg);
                        txt_volume_especifico.setText(volume_especifico + String.format("%.5f", v_especifico)  + m3_kg);

                        Double inf = Double.POSITIVE_INFINITY;

                        if (p == inf || t == inf || h == inf || s == inf || u == inf || (1/v_especifico) == inf){
                            if ( (codigo_propriedade_um.equals("P") && codigo_propriedade_dois.equals("T") ) || (codigo_propriedade_um.equals("T") && codigo_propriedade_dois.equals("P") )) {
                                Toast.makeText(TelaCalculadora.this, "Erro! Os valores de Pressão e Temperatura não são independentes ou são incompatíveis.", Toast.LENGTH_LONG).show();
                            } else{
                                Toast.makeText(TelaCalculadora.this, "Erro! Os valores selecionados são incompatíveis", Toast.LENGTH_SHORT).show();
                            }

                        }

                    } else {
                        Toast.makeText(TelaCalculadora.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    }

                }



            }
        });

    }

    private String codigo(String propriedade) {

        String retorno;

        switch (propriedade) {
            case "Pressão (kPa)":
                retorno = "P";
                break;
            case "Temperatura (ºC)":
                retorno = "T";
                break;
            case "Entalpia (kJ/kg)":
                retorno = "H";
                break;
            case "Entropia (kJ/kg.K)":
                retorno = "S";
                break;
            case "Energia Interna (kJ/kg)":
                retorno = "U";
                break;
            case "Volume Específico (m³/kg)":
                retorno = "D";
                break;
            case "Líquido Saturado":
                retorno = "Q";
                break;
            case "Vapor Saturado":
                retorno = "Q";
                break;
            default:
                retorno = propriedade;

        }

        return retorno;
    }

}


