package com.androidapps.royrga.bdapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextWatcher;

public class AgregarUsuario extends AppCompatActivity implements View.OnClickListener{
    SQLiteDatabase db;
    Button add;
    EditText name;
    EditText edad;
    EditText cel;
    EditText email;
    boolean field1=false;
    boolean field2=false;
    boolean field3=false;
    boolean field4=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

         add = (Button) findViewById(R.id.ButtonAgregar);
        add.setOnClickListener(this);

        DataBase usuarios = new DataBase( this,"Usuarios",null,1);
        db = usuarios.getWritableDatabase();
        if(db != null)
        {Toast.makeText(this, "BD abierta correctamente", Toast.LENGTH_SHORT).show();}
        else{Toast.makeText(this, "BD fallo abrir", Toast.LENGTH_SHORT).show();}

        name= (EditText) findViewById(R.id.editTextName);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    field1=true;
                }
            }
        });

        edad= (EditText) findViewById(R.id.editTextEdad);
        edad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    field2=true;
                }
            }
        });

        cel= (EditText) findViewById(R.id.editTextCel);
        cel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length()>9 && editable.length()<11){
                    Toast.makeText(AgregarUsuario.this, "Celular valido", Toast.LENGTH_SHORT).show();
                }else{
                    if (editable != null) {
                        field3=true;
                    }
                }

            }
        });

        email= (EditText) findViewById(R.id.editTextEmail);
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    field4=true;
                }
                if(field1 && field2 && field3 ){
                    add.setEnabled(true);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        try{
            db.execSQL("INSERT INTO usuarios (nombre,edad,email,celular)" +
                    "VALUES ('"+name.getText()+"'," +
                    "'"+Integer.parseInt(edad.getText().toString())+"'," +
                    "'"+email.getText()+"'," +
                    "'"+Long.parseLong(cel.getText().toString())+"')");
            Toast.makeText(this, "Usuario agregado con exito", Toast.LENGTH_SHORT).show();
            name.setText("Nombre");
            edad.setText("Edad");
            email.setText("E-mail");
            cel.setText("Celular");
        }catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
