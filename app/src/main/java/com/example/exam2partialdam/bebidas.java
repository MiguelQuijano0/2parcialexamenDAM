package com.example.exam2partialdam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bebidas extends AppCompatActivity {

    EditText editText_namebebida;
    EditText editText_preciobebida;
    Button next2;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String key_namebebida = "bebida";
    private static final String Key_preciobebida = "preciobebida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);
        editText_namebebida = findViewById(R.id.editnamebebida);
        editText_preciobebida= findViewById(R.id.editpreciobebida);
        next2 = findViewById(R.id.buttonnext2);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name= sharedPreferences.getString(key_namebebida,null);
        if (name !=null){
            Intent intent= new Intent (bebidas.this, pedido.class );
            startActivity(intent);
        }
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString(key_namebebida,editText_namebebida.getText().toString());
                editor.putString(Key_preciobebida,editText_preciobebida.getText().toString());
                editor.apply();

                Intent intent = new Intent( bebidas.this,pedido.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);

                Toast.makeText(bebidas.this, "bebida selecionada", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void backon (View view){
        Intent b = new Intent(this,MainActivity2.class);
        startActivity(b);
        overridePendingTransition(R.anim.left_in,R.anim.left_out);
    }
}