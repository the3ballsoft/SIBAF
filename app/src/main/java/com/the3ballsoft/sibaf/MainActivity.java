package com.the3ballsoft.sibaf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.the3ballsoft.sibaf.R;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registrarHuellas(View view){
       Intent intent = new Intent(this, RegistrarHuellaActivity.class);
        startActivity(intent);
    }

    public void importarDatos(View view){
        Toast.makeText(getApplicationContext(), "no implementado", Toast.LENGTH_LONG).show();
    }
    public void exportarDatos(View view){
        Toast.makeText(getApplicationContext(), "no implementado", Toast.LENGTH_LONG).show();
    }
    public void salir(View view){
        finish();
    }
}
