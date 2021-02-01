package com.pietrosales.ciclos_rankine.Entradas;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.pietrosales.ciclos_rankine.R;
import com.pietrosales.ciclos_rankine.Saidas.SaidasRegenerativo;

public class TelasResultadosRegenerativo extends AppCompatActivity {

    private Toolbar toolbar;
    private Button calcular;
    private CheckBox checkBox;
    private EditText edt_temperatura, edt_pressao_baixa, edt_pressao_alta, edt_pressao_intermediaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telas_resultados_regenerativo);

        calcular = findViewById(R.id.btn_calcular);

        toolbar = findViewById(R.id.toolbar);

        checkBox = findViewById(R.id.checkBox);

        edt_temperatura = findViewById(R.id.edt_temperatura);
        edt_pressao_baixa = findViewById(R.id.edt_inferior);
        edt_pressao_alta = findViewById(R.id.edt_superior);
        edt_pressao_intermediaria = findViewById(R.id.edt_intermediaria);

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

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {
                    //Desabilitar CheckBox
                    edt_temperatura.setEnabled(false);
                    edt_temperatura.setInputType(InputType.TYPE_CLASS_TEXT);
                    edt_temperatura.setText("Vapor Saturado");
                    edt_temperatura.setFocusable(false);
                    edt_temperatura.setClickable(false);
                    edt_temperatura.setError(null);
                }
                else{
                    //Habilitar CheckBox
                    edt_temperatura.setEnabled(true);
                    edt_temperatura.setText("");
                    edt_temperatura.setInputType(InputType.TYPE_CLASS_NUMBER);
                    edt_temperatura.setFocusableInTouchMode(true);
                    edt_temperatura.setClickable(true);
                }

            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p_baixa = edt_pressao_baixa.getText().toString();
                String p_intermediaria = edt_pressao_intermediaria.getText().toString();
                String p_alta = edt_pressao_alta.getText().toString();
                String temperatura = edt_temperatura.getText().toString();
                Boolean preenchido = validateForm(p_baixa, p_intermediaria, p_alta, temperatura);
                if (preenchido == Boolean.TRUE) {

                    if (Float.valueOf(p_alta) >= Float.valueOf(p_intermediaria)) {

                        if (Float.valueOf(p_intermediaria) >= Float.valueOf(p_baixa)) {


                            Intent intent = new Intent(TelasResultadosRegenerativo.this, SaidasRegenerativo.class);

                            intent.putExtra("p_baixa", Float.valueOf(p_baixa));
                            intent.putExtra("p_intermediaria", Float.valueOf(p_intermediaria));
                            intent.putExtra("p_alta", Float.valueOf(p_alta));
                            if (temperatura.equals("Vapor Saturado")){
                                intent.putExtra("temperatura", Float.valueOf("-1"));
                            } else {
                                intent.putExtra("temperatura", Float.valueOf(temperatura));
                            }

                            startActivity(intent);

                        } else {
                            Toast.makeText(TelasResultadosRegenerativo.this, "Pressão intermediária deve ser maior ou igual à pressão inferior", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(TelasResultadosRegenerativo.this, "Pressão superior deve ser maior ou igual à pressão intermediária", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(TelasResultadosRegenerativo.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean validateForm(String p_baixa, String p_intermediaria, String p_alta, String temperatura) {
        boolean valid = true;

        if (TextUtils.isEmpty(p_baixa)) {
            edt_pressao_baixa.setError("Obrigatório");
            valid = false;
        } else {
            edt_pressao_baixa.setError(null);
        }

        if (TextUtils.isEmpty(p_intermediaria)) {
            edt_pressao_intermediaria.setError("Obrigatório");
            valid = false;
        } else {
            edt_pressao_intermediaria.setError(null);
        }

        if (TextUtils.isEmpty(p_alta)) {
            edt_pressao_alta.setError("Obrigatório");
            valid = false;
        } else {
            edt_pressao_alta.setError(null);
        }

        if (TextUtils.isEmpty(temperatura)) {
            edt_temperatura.setError("Obrigatório");
            valid = false;
        } else {
            edt_temperatura.setError(null);
        }

        return valid;
    }


}

