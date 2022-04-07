package com.example.exam2partialdam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class pedido extends AppCompatActivity {
    TextView textView_name2;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String key_name = "name";
    private static final String Key_password = "password";
    private static final String key_namepizza = "pizza";
    private static final String Key_precio = "precio";
    private static final String key_namebebida = "bebida";
    private static final String Key_preciobebida = "preciobebida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        textView_name2 = findViewById(R.id.messagefinal);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(key_name,null);
        String password = sharedPreferences.getString(Key_password,null);
        String namepizza = sharedPreferences.getString(key_namepizza, null);
        String preciopizza = sharedPreferences.getString(Key_precio, null);
        String namebebida = sharedPreferences.getString(key_namebebida, null);
        String preciobebida = sharedPreferences.getString(Key_preciobebida, null);
        int valor1 = Integer.parseInt(preciopizza);
        int valor2 = Integer.parseInt(preciobebida);
        int total = valor1 + valor2;

        if(name!=null || password !=null || namepizza != null|| preciopizza != null || namebebida != null || preciobebida != null){
            if(!name.equals("")&&!password.equals("")&&!namepizza.equals("")&&!preciopizza.equals("")&&!namebebida.equals("")&&!preciobebida.equals("")) {
                textView_name2.setText( name +" ordeno una "+namepizza+" con precio de " +preciopizza +" y una " +namebebida+" con precio de "+preciobebida+ " su total a pagar es $"+total +" pesos" );
            }
            else
                textView_name2.setText("Los datos que enviaste son incorrectos");
        }
    }
}