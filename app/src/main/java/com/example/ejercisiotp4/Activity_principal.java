package com.example.ejercisiotp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity_principal extends AppCompatActivity {

    private Button button_inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findView(); //Metodo p0ara organizar.
    }

    public boolean onCreateOptionsMenu (Menu menu){ //crear el menu ya hecho.

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu); //inyectamos dentro de la vista ya creada, en el menu que seleccionemos, con la palabra inflater.
        return true;
    }

    public boolean onOptionsItemSelected (@NonNull MenuItem item){ // Escucha que items preciona o toca el Usuario.

        switch (item.getItemId()){
            case R.id.Salir_App: // Sale de la app completa.
                System.exit(0);
                return true;
            case R.id.CerrarSesion: // Cierrasesion, y vuelve a la pantalla principal
                Toast.makeText(Activity_principal.this, "No esta Permitido", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Camara_activar:
                Toast.makeText(Activity_principal.this, "No esta Permitido", Toast.LENGTH_SHORT).show();
            case R.id.Cuenta_config:
                Toast.makeText(Activity_principal.this, "No esta Permitido", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void findView (){ //Metodo para organizar.
        button_inicio = findViewById(R.id.button_inicio);
    }

    public void onClick (View v){ //Metodo para Oneclick itents ala siguiente activity.
        Intent start = new Intent(Activity_principal.this, Activity_Login.class);
        startActivity(start);
        findView();
    }
}