package com.androidapps.royrga.bdapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ConsultActivity extends AppCompatActivity {
    SQLiteDatabase db;
    RecyclerView rv;
    ArrayList <String> listUsuarios;
    RecyclerView.Adapter rwAdapter;
    RecyclerView.LayoutManager rwLayouMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv = (RecyclerView) findViewById(R.id.recyclerV);

        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        listUsuarios = new ArrayList<String>();



        DataBase usuarios = new DataBase( this,"Usuarios",null,1);
        db = usuarios.getWritableDatabase();

        //String[] args = new string[] {
        Cursor c = db.rawQuery("SELECT * FROM usuarios",null);
        if (c.moveToFirst()) {

            //Recorremos el cursor hasta que no haya más registros
            do {
                Integer id= c.getInt(0);
                String nombre = c.getString(1);
                Integer edad = c.getInt(2);
                String email = c.getString(3);
                Long celular = c.getLong(4);
                listUsuarios.add(nombre+" "+edad);
            } while(c.moveToNext());
        }
        MyAdapterConsult adapter = new MyAdapterConsult(listUsuarios);
        rv.setAdapter(adapter);
    }

}
