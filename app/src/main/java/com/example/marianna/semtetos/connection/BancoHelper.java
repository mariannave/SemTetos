package com.example.marianna.semtetos.connection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Marianna on 08/02/2017.
 */

public class BancoHelper extends SQLiteOpenHelper {

    public BancoHelper(Context context) {
        super(context, "semtetosdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS anuncio(id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR(100), descricao VARCHAR(255), anunciante VARCHAR(100), contato VARCHAR(12), imagemURL VARCHAR(255));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table anuncio;");
        this.onCreate(db);
    }
}

