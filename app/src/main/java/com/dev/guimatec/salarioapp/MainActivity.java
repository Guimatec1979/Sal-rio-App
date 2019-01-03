package com.dev.guimatec.salarioapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private EditText edtFuncionario,edtHoras_trabalhadas,edtValorHora;
    private TextView txtNumeroFuncionario,txtSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InicializarComponentes();
    }

    private void InicializarComponentes() {

        edtFuncionario = findViewById(R.id.edtFuncionario);
        edtHoras_trabalhadas = findViewById(R.id.edtHoras_trabalhadas);
        edtValorHora = findViewById(R.id.edtValorHora);
        txtNumeroFuncionario = findViewById(R.id.txtNumeroFuncionario);
        txtSalario = findViewById(R.id.txtSalario);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    int ID = Integer.parseInt(edtFuncionario.getText().toString());
                    int hora = Integer.parseInt(edtHoras_trabalhadas.getText().toString());
                    double salario = Double.parseDouble(edtValorHora.getText().toString());
                    double total = hora * salario;

                    txtNumeroFuncionario.setText("Número Funcionário: " + ID);
                    txtSalario.setText("Salário: R$ " + total);

                    limpar();

                }catch (Exception e){

                    Toast.makeText(MainActivity.this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();

                }



            }
        });
    }

    private void limpar() {
        edtFuncionario.setText("");
        edtValorHora.setText("");
        edtHoras_trabalhadas.setText("");
    }
}
