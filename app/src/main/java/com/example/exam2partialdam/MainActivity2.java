package com.example.exam2partialdam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {
    TextView textView_name;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String key_name = "name";
    private static final String Key_password = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView_name = findViewById(R.id.message);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(key_name,null);
        String password = sharedPreferences.getString(Key_password,null);

        if(name!=null || password !=null){
            if(!name.equals("")&&!password.equals("")){
                textView_name.setText("Bienvenido "+name+" ¿qué te podemos llevar hasta tu casa este día?");
            }
            else
                textView_name.setText("Los datos que enviaste son incorrectos");
        }
    }
    public void pizza (View view){
        Intent pizza = new Intent(this,pizzas.class);
        startActivity(pizza);
        overridePendingTransition(R.anim.left_in,R.anim.left_out);
    }
    public void bebida (View view){
        Intent bebida = new Intent(this,bebidas.class);
        startActivity(bebida);
        overridePendingTransition(R.anim.left_in,R.anim.left_out);
    }
}
