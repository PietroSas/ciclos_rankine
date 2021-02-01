package com.pietrosales.ciclos_rankine.Entradas;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.pietrosales.ciclos_rankine.R;
import com.pietrosales.ciclos_rankine.Saidas.SaidasSimples;

public class TelaResultadosSimples extends AppCompatActivity {

    private Toolbar toolbar;
    private Button calcular;
    private CheckBox checkBox;
    private EditText edt_temperatura, edt_pressao_baixa, edt_pressao_alta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_resultados_simples);

        calcular = findViewById(R.id.btn_calcular);
        toolbar = findViewById(R.id.toolbar);
        checkBox = findViewById(R.id.checkBox);
        edt_temperatura = findViewById(R.id.edt_temperatura);
        edt_pressao_baixa = findViewById(R.id.edt_inferior);
        edt_pressao_alta = findViewById(R.id.edt_superior);

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
                String p_alta = edt_pressao_alta.getText().toString();
                String temperatura = edt_temperatura.getText().toString();
                Boolean preenchido = validateForm(p_baixa, p_alta, temperatura);
                if (preenchido == Boolean.TRUE) {

                    if (Float.valueOf(p_alta) >= Float.valueOf(p_baixa)) {
                        Intent intent = new Intent(TelaResultadosSimples.this, SaidasSimples.class);

                        intent.putExtra("p_baixa", Float.valueOf(p_baixa));
                        intent.putExtra("p_alta", Float.valueOf(p_alta));
                        if (temperatura.equals("Vapor Saturado")) {
                            intent.putExtra("temperatura", Float.valueOf("-1"));
                        } else {
                            intent.putExtra("temperatura", Float.valueOf(temperatura));
                        }
                        startActivity(intent);
                    } else {

                        Toast.makeText(TelaResultadosSimples.this, "Pressão superior deve ser maior ou igual à pressão inferior", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(TelaResultadosSimples.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean validateForm(String p_baixa, String p_alta, String temperatura) {
        boolean valid = true;

        if (TextUtils.isEmpty(p_baixa)) {
            edt_pressao_baixa.setError("Obrigatório");
            valid = false;
        } else {
            edt_pressao_baixa.setError(null);
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
