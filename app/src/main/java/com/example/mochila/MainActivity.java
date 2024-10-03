package com.example.mochila;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int pesoGorras = 2;
    int pesoBañadores = 1;
    int pesoCamisetas = 1;
    int pesoZapatos = 3;
    int pesoPantalones = 2;
    int pesoLibros = 8;

    int pesoTotal = 0;

    TextView textPesoMochila;
    CheckBox checkGorras, checkBañadores, checkCamisetas, checkZapatos, checkPantalones, checkLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPesoMochila = findViewById(R.id.textPesoMochila);
        checkGorras = findViewById(R.id.checkGorras);
        checkBañadores = findViewById(R.id.checkBañadores);
        checkCamisetas = findViewById(R.id.checkCamisetas);
        checkZapatos = findViewById(R.id.checkZapatos);
        checkPantalones = findViewById(R.id.checkPantalones);
        checkLibros = findViewById(R.id.checkLibros);
        Button buttonVaciar = findViewById(R.id.buttonVaciar);

        actualizarPeso();

        checkGorras.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso());
        checkBañadores.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso());
        checkCamisetas.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso());
        checkZapatos.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso());
        checkPantalones.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso());
        checkLibros.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarPeso());

        buttonVaciar.setOnClickListener(v -> vaciarMochila());
    }

    private void actualizarPeso() {
        pesoTotal = 0;

        if (checkGorras.isChecked()) pesoTotal += pesoGorras;
        if (checkBañadores.isChecked()) pesoTotal += pesoBañadores;
        if (checkCamisetas.isChecked()) pesoTotal += pesoCamisetas;
        if (checkZapatos.isChecked()) pesoTotal += pesoZapatos;
        if (checkPantalones.isChecked()) pesoTotal += pesoPantalones;
        if (checkLibros.isChecked()) pesoTotal += pesoLibros;

        textPesoMochila.setText("Peso " + pesoTotal + " Kg");

        if (pesoTotal > 20) {
            textPesoMochila.setTextColor(Color.RED);
        } else {
            textPesoMochila.setTextColor(Color.BLACK);
        }
    }

    private void vaciarMochila() {

        checkGorras.setChecked(false);
        checkBañadores.setChecked(false);
        checkCamisetas.setChecked(false);
        checkZapatos.setChecked(false);
        checkPantalones.setChecked(false);
        checkLibros.setChecked(false);

        actualizarPeso();
    }
}
