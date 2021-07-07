package com.example.ejercisiotp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Registrar extends AppCompatActivity {

    private Button button_grabar, button2_login;
    private EditText editText_nombrecompleto, editText_nombreusuario, editText_EmailAddress, editText_Password2, editText_RepetirPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        this.findView(); //Metodo para organizar.

        button_grabar.setOnClickListener(new View.OnClickListener() {//Metodo para Oneclick itents ala siguiente activity.
            @Override
            public void onClick(View v) {
                String Contraseña = editText_Password2.getText().toString();
                String Contrasena_Rep = editText_RepetirPassword.getText().toString();

                if (Contraseña.equals(Contrasena_Rep)) {
                    Guardar_SharedPreferencias_Claves(); // Funcion para almacenar Usuario y contraseña al registrar..
                    Intent start = new Intent(Activity_Registrar.this, Activity_Login.class);
                    clear();
                    startActivity(start);
                }else{
                    Toast.makeText(Activity_Registrar.this, "Contraseña No son Iguales", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button2_login.setOnClickListener(new View.OnClickListener() {//Metodo para Oneclick itents ala siguiente activity.
            @Override
            public void onClick(View v) {
                String Contraseña = editText_Password2.getText().toString();
                String Contrasena_Rep = editText_RepetirPassword.getText().toString();

                if (Contraseña.equals(Contrasena_Rep)) {
                    Guardar_SharedPreferencias_Claves(); // Funcion para almacenar Usuario y contraseña al registrar..
                    Intent start = new Intent(Activity_Registrar.this, Activity_InicioSesion.class);
                    clear();
                    startActivity(start);
                }else{
                    Toast.makeText(Activity_Registrar.this, "Contraseña No son Iguales", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(Activity_Registrar.this, "No esta Permitido", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Camara_activar:
                Toast.makeText(Activity_Registrar.this, "App en Proceso", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Cuenta_config:
                Toast.makeText(Activity_Registrar.this, "No esta Permitido ", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void findView (){ //Metodo para organizar.
        editText_nombrecompleto = findViewById(R.id.editText_nombrecompleto);
        editText_nombreusuario = findViewById(R.id.editText_nombreusuario);
        editText_EmailAddress = findViewById(R.id.editText_EmailAddress);
        editText_Password2 = findViewById(R.id.editText_Password2);
        editText_RepetirPassword = findViewById(R.id.editText_RepetirPassword);
        button_grabar = findViewById(R.id.button_grabar);
        button2_login = findViewById(R.id.button2_login);
    }

    public void clear() {//Borra lo que se encuentra escrito en el edit antes de que el usuario escriba algo.

        editText_nombrecompleto.setText("");
        editText_nombreusuario.setText("");
        editText_EmailAddress.setText("");
        editText_Password2.setText("");
        editText_RepetirPassword.setText("");
    }

    private void Guardar_SharedPreferencias_Claves(){

        SharedPreferences preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE); //Metodo para llamar a getSharedPreferences, con nombre credenciales, y modo privado
        String Nombre_Completo = editText_nombrecompleto.getText().toString(); //Almacena en la variable Nombre_Completo, el contenido de los campos.
        String Usuario = editText_nombreusuario.getText().toString(); //Almacena en la variable Usuario, el contenido de los campos.
        String Correo_Electronico = editText_EmailAddress.getText().toString(); //Almacena en la variable Correo_Electronico, el contenido de los campos.
        String Contraseña = editText_Password2.getText().toString();  //Almacena en la variable contraseña, el contenido de los campos.

        SharedPreferences.Editor editor = preferences.edit(); // para editar el preference realizado.

        editor.putString("Nombre Completo",Nombre_Completo); // almacena en preference, el campo seleccionado, con el nombre Nombre Completo.
        editor.putString("Usuario",Usuario); // almacena en preference, el campo seleccionado, con el nombre usuario.
        editor.putString("Correo Electronico",Correo_Electronico); // almacena en preference, el campo seleccionado, con el nombre Correo Electronico.
        editor.putString("Contraseña",Contraseña);  // almacena en preference, el campo seleccionado, con el nombre contraseña.

        editor.commit(); // Aplicar cambios, se llama al commit().
    }
}