package com.example.vi_ni.controlegasto;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText edtLimite, edtGasto;
    private TextView txtLimite, txtGasto, txtPodeGastar, txtAviso;

//    private double gastoA = 0.0;
//    private double gasto = 0.0;
//    private double limite = 0.0;
//    private double podeGastar = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLimite = findViewById(R.id.edtLimite);
        edtGasto = findViewById(R.id.edtGasto);
        txtLimite = findViewById(R.id.txtLimite);
        txtGasto = findViewById(R.id.txtGasto);
        txtPodeGastar = findViewById(R.id.txtPodeGastar);
        txtAviso = findViewById(R.id.txtAviso);
    }

    public void defineLimite(View view) {
        double limite = Double.parseDouble(edtLimite.getText().toString());
        double gasto = Double.parseDouble(edtGasto.getText().toString());
        double podeGastar = limite - gasto;

        edtLimite.setEnabled(false);

        txtGasto.setText("Gastos: " + String.valueOf(gasto));
        txtLimite.setText("Limite de Gastos: "+ String.valueOf(limite));
        if (gasto > limite){
            txtPodeGastar.setText("Pode gastar: 0");
            txtAviso.setText("Seu gasto foi maior que o limite definido");
            txtAviso.setTextColor(Color.RED);
        }else {
            txtPodeGastar.setText("Pode gastar: " + String.valueOf(podeGastar));
            txtAviso.setText("Seu gasto está dentro do limite definido");
            txtAviso.setTextColor(Color.BLUE);
        }

    }
}
