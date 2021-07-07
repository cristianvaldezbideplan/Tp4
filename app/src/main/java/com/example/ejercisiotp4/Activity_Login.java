package com.example.ejercisiotp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Login extends AppCompatActivity {

    private Button button_registrar, button2_Ingresar;
    private EditText editTextNumberPassword, editTextTextPersonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.findView(); //Metodo para organizar.


        button_registrar.setOnClickListener(new View.OnClickListener() {//Metodo para Oneclick itents ala siguiente activity.
            @Override
            public void onClick(View v) {
                Intent start = new Intent(Activity_Login.this, Activity_Registrar.class);
                clear();
                startActivity(start);
            }
        });

        button2_Ingresar.setOnClickListener(new View.OnClickListener() {//Metodo para Oneclick itents ala siguiente activity.
            @Override
            public void onClick(View v) {
                String Usuario = editTextTextPersonName.getText().toString();
                String Contrasena = editTextNumberPassword.getText().toString();

                SharedPreferences preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE); //Metodo para llamar a getSharedPreferences, con nombre credenciales, y modo privado
                String Usuario_pre = preferences.getString("Usuario", ""); // almacena en Usuario_pre (variable) y trae lo que tiene usuario en shared.
                String Contraseña_pre = preferences.getString("Contraseña","");  // almacena en Contraseña_pre (variable) y trae lo que tiene contraseña en shared.

                if ( Usuario.equals(Usuario_pre) && Contrasena.equals(Contraseña_pre) || Usuario.equals("alumno") && Contrasena.equals("123456")  ) {
                    Intent start = new Intent(Activity_Login.this, Activity_InicioSesion.class);
                    clear();
                    startActivity(start);
                }else{
                    Toast.makeText(Activity_Login.this, "Datos Incorrector", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public boolean onCreateOptionsMenu (Menu menu){ //crear el menu ya hecho.

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu); //inyectamos dentro de la vista ya creada, en el menu que seleccionemos, con la palabra inflater.
        return true;
    }

    public boolean onOptionsItemSelected (@NonNull MenuItem item){ // Escucha que items preciona o toca el Usuario.

        switch (item.getItemId()){
            case R.id.Salir_App: // Sale de la app completa.
                finish();
                return true;
            case R.id.CerrarSesion: // Cierrasesion, y vuelve a la pantalla principal
                Toast.makeText(Activity_Login.this, "No esta Permitido", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Camara_activar:
                Toast.makeText(Activity_Login.this, "App en Proceso", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Cuenta_config:
                Toast.makeText(Activity_Login.this, "No esta Permitido ", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void findView (){ //Metodo para organizar.
        button_registrar = findViewById(R.id.button_registrar);
        button2_Ingresar = findViewById(R.id.button2_Ingresar);
        editTextNumberPassword = findViewById(R.id.editTextNumberPassword);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        button_registrar = findViewById(R.id.button_registrar);
        button2_Ingresar = findViewById(R.id.button2_Ingresar);

    }

    public void clear() {//Borra lo que se encuentra escrito en el edit antes de que el usuario escriba algo.

        editTextTextPersonName.setText("");
        editTextNumberPassword.setText("");
    }

}