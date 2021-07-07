package com.example.ejercisiotp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_InicioSesion extends AppCompatActivity {

    private Button button_correo, button2_telefono, button3_sitiowed, button4_Github;
    private TextView textView_titulo3;
    private static final String tag = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        this.findView(); //Metodo para organizar.


        button2_telefono.setOnClickListener(new View.OnClickListener() {//Metodo para Oneclick itents ala siguiente activity.
            @Override
            public void onClick(View v) {
                Intent Tel = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:15551234"));
                startActivity(Tel);
            }
        });

        button4_Github.setOnClickListener(new View.OnClickListener() {//Metodo para Oneclick itents ala siguiente activity.
            @Override
            public void onClick(View v) {
                Intent GH = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/cristianvaldezbideplan"));
                startActivity(GH);
            }
        });

        button3_sitiowed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/"));
                startActivity(webIntent);
            }
        });

        button_correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                Uri uri = Uri.parse("mailto:valdejor05@gmail.com");
                intent.setData(uri);
                intent.putExtra("subject", "my subject");
                intent.putExtra("body", "my message");
                startActivity(intent);
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
                Intent start = new Intent(Activity_InicioSesion.this, Activity_principal.class);
                startActivity(start);
                return true;
            case R.id.Camara_activar:
                Toast.makeText(Activity_InicioSesion.this, "App en Proceso", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Cuenta_config:
                Intent start2 = new Intent(Activity_InicioSesion.this, Activity_Cuenta_Configured.class);
                startActivity(start2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void findView (){ //Metodo para organizar.
        button_correo = findViewById(R.id.button_correo);
        button2_telefono = findViewById(R.id.button2_telefono);
        button3_sitiowed = findViewById(R.id.button3_sitiowed);
        button4_Github = findViewById(R.id.button4_Github);
        textView_titulo3 = findViewById(R.id.textView_titulo3);
    }

}