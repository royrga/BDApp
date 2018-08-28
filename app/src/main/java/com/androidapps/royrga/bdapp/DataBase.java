package com.androidapps.royrga.bdapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE usuarios (" +
            "id      INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre  TEXT NOT NULL," +
            "edad    INTEGER NOT NULL, " +
            "email   TEXT, " +
            "celular INTEGER)";

    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
