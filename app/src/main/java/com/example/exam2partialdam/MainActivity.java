package com.example.exam2partialdam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText_name;
    EditText editText_password;
    Button login;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String key_name = "name";
    private static final String Key_password = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.edituser);
        editText_password= findViewById(R.id.editpassword);
        login = findViewById(R.id.button);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name= sharedPreferences.getString(key_name,null);
        if (name !=null){
            Intent intent= new Intent (MainActivity.this, MainActivity2.class );
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString(key_name,editText_name.getText().toString());
                editor.putString(Key_password,editText_password.getText().toString());
                editor.apply();

                Intent intent = new Intent( MainActivity.this,MainActivity2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_back_in,R.anim.zoom_back_out);

                Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}