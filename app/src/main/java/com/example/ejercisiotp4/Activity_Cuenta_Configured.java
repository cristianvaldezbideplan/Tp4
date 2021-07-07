package com.example.ejercisiotp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Cuenta_Configured extends AppCompatActivity {

    private Button button_CambiarConfig;
    private EditText editText_nombreusuario_config, editText_Password2_config, editText_RepetirPassword_Config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta_configured);

        this.findView(); //Metodo para organizar.

        button_CambiarConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contrasena = editText_Password2_config.getText().toString();
                String Rep_Contrasena = editText_Password2_config.getText().toString();

                if (Contrasena.equals(Rep_Contrasena)) {
                    Guardar_SharedPreferencias_Claves(); // Funcion para almacenar Usuario y contraseña al registrar..
                    Intent start = new Intent(Activity_Cuenta_Configured.this, Activity_InicioSesion.class);
                    Toast.makeText(Activity_Cuenta_Configured.this, "Se Guardo exitosamente", Toast.LENGTH_SHORT).show();
                    clear();
                    startActivity(start);
                }else{
                    Toast.makeText(Activity_Cuenta_Configured.this, "Contraseña No son Iguales", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private void findView () { //Metodo para organizar.
        button_CambiarConfig = findViewById(R.id.button_CambiarConfig);
        editText_nombreusuario_config = findViewById(R.id.editText_nombreusuario_config);
        editText_Password2_config = findViewById(R.id.editText_Password2_config);
        editText_RepetirPassword_Config = findViewById(R.id.editText_RepetirPassword_Config);
    }

    public void clear() {//Borra lo que se encuentra escrito en el edit antes de que el usuario escriba algo.

        editText_nombreusuario_config.setText("");
        editText_Password2_config.setText("");
        editText_RepetirPassword_Config.setText("");

    }

    private void Guardar_SharedPreferencias_Claves(){

        SharedPreferences preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE); //Metodo para llamar a getSharedPreferences, con nombre credenciales, y modo privado

        String Usuario = editText_nombreusuario_config.getText().toString(); //Almacena en la variable Usuario, el contenido de los campos.
        String Contraseña = editText_Password2_config.getText().toString();

        SharedPreferences.Editor editor = preferences.edit(); // para editar el preference realizado.

        editor.putString("Usuario",Usuario); // almacena en preference, el campo seleccionado, con el nombre usuario.
        editor.putString("Contraseña",Contraseña);  // almacena en preference, el campo seleccionado, con el nombre contraseña.

        editor.commit(); // Aplicar cambios, se llama al commit().
    }

}