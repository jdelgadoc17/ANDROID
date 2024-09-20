package com.example.contador;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contador.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;



    public static int contador;
    public static final String VALOR_CONTADOR ="Valor del contador";


    @Override
    public void onSaveInstanceState( Bundle savedInstanceState) {
        savedInstanceState.putInt(VALOR_CONTADOR, contador);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        contador=0;

        if(savedInstanceState!=null){
            contador=savedInstanceState.getInt(VALOR_CONTADOR);
            binding.contadorNumerico.setText(String.valueOf(contador));

        }else{
            contador=0;
        }


        //BOTON CONTADOR
        binding.contadorBotonClick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                contador++;
                binding.contadorNumerico.setText(String.valueOf(contador));
            }
        });

        //HACER BOTON RESET
        binding.contadorBotonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador=0;
                binding.contadorNumerico.setText(String.valueOf(contador));


            }
        });












    }




}