package com.example.Tarea_1_3_Salvar_Informacion_SQlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Tarea_1_3_Salvar_Informacion_SQlite.configuracion.SQLiteConexion;
import com.example.Tarea_1_3_Salvar_Informacion_SQlite.configuracion.Transacciones;

public class ActivityIngresar extends AppCompatActivity {
    EditText nombres, apellidos, edad, correo, direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
        nombres = (EditText) findViewById(R.id.txtnombre);
        apellidos =(EditText) findViewById(R.id.txtapellidos);
        edad = (EditText)  findViewById(R.id.txtedad);
        correo = (EditText) findViewById(R.id.txtcorreo);
        direccion = (EditText) findViewById(R.id.txtdireccion);
        Button btnsalvar = (Button) findViewById(R.id.btnsalvar);

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarPersonas();
            }
        });

    }
    private void AgregarPersonas()
    {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.apellidos, apellidos.getText().toString());
        valores.put(Transacciones.edad, edad.getText().toString());
        valores.put(Transacciones.correo, correo.getText().toString());
        valores.put(Transacciones.direccion, direccion.getText().toString());

        Long resultado = db.insert(Transacciones.tablaPersonas,Transacciones.id,valores);

        Toast.makeText(getApplicationContext(), "REGISTRO INGRESADO CON EXITO : CONSULTA " + resultado.toString(),Toast.LENGTH_LONG).show();

        db.close();

        LimpiarPantalla();

    }

    private void LimpiarPantalla()
    {
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
        direccion.setText("");
    }
}