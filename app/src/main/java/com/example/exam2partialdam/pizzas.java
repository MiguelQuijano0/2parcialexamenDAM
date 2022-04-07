package com.example.exam2partialdam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pizzas extends AppCompatActivity {
    EditText editText_namepizza;
    EditText editText_preciopizza;
    Button next;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String key_namepizza = "pizza";
    private static final String Key_precio = "precio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);
        editText_namepizza = findViewById(R.id.editnamepizza);
        editText_preciopizza= findViewById(R.id.editpreciopizza);
        next = findViewById(R.id.buttonnext);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name= sharedPreferences.getString(key_namepizza,null);
        if (name !=null){
            Intent intent= new Intent (pizzas.this, bebidas.class );
            startActivity(intent);
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString(key_namepizza,editText_namepizza.getText().toString());
                editor.putString(Key_precio,editText_preciopizza.getText().toString());
                editor.apply();

                Intent intent = new Intent( pizzas.this,bebidas.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);

                Toast.makeText(pizzas.this, "pizzas selecionada", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void backon (View view){
        Intent t = new Intent(this,MainActivity2.class);
        startActivity(t);
        overridePendingTransition(R.anim.left_in,R.anim.left_out);
    }
}