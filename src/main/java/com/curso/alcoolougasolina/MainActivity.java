package com.curso.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private TextInputEditText textInputAlcool, textInputGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);
        textInputAlcool = findViewById(R.id.textInputAlcool);
        textInputGasolina = findViewById(R.id.textInputGasolina);
    }

    public void CalcularPreco(View view){
        // pegando valores digitados
        String precoAlcool = textInputAlcool.getText().toString();
        String precoGasolina = textInputGasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);//true = validados / false = n validados

        if (camposValidados){
            Double valorAlcool = Double.parseDouble(precoAlcool); // convertendo uma string em double
            Double valorGasolina = Double.parseDouble(precoGasolina);

            if ((valorAlcool / valorGasolina) >= 0.7){
                textResultado.setText("Melhor usar Gasolina!");
            }else{
                textResultado.setText("Melhor usar Álcool");
            }


        }else {
            textResultado.setText("Preencha os preços primeiro!");
        }

    }

    public Boolean validarCampos (String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        // verificando se o usuario digitou os valores ou se ta null ou vazio (equals)
        if (pAlcool == null || pAlcool.equals("")){ // pAlcool.equals = pAlcool for igual a nulo ("") "vazio"
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false; // se n for preenchido vai retornar false
        }

        return camposValidados;
    }
}
