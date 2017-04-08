package com.example.marianna.semtetos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.marianna.semtetos.connection.BancoHelper;
import com.example.marianna.semtetos.model.Anuncio;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AnuncioDAO {
    private SQLiteDatabase banco;

    public AnuncioDAO(Context context) {
        this.banco = new BancoHelper(context).getWritableDatabase();
    }

    public void insert(Anuncio anuncio) {

        // Transforma em stream -> array de bytes
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        anuncio.getImagem().compress(Bitmap.CompressFormat.PNG, 100, stream);


        ContentValues cv = new ContentValues();
        cv.put("tipo", anuncio.getTipoDoAnuncio());
        cv.put("titulo", anuncio.getTitulo());
        cv.put("descricao", anuncio.getDescricao());
        cv.put("anunciante", anuncio.getAnunciante());
        cv.put("contato", anuncio.getContato());
        cv.put("imagem", stream.toByteArray());
        banco.insert("anuncio", null, cv);
    }

    public List<Anuncio> get() {
        List<Anuncio> lista = new ArrayList<Anuncio>();
        String colunas[] = {"id", "tipo", "titulo", "descricao", "anunciante", "contato", "imagem"};
        Cursor c = this.banco.query("anuncio", colunas, null, null, null, null, "titulo");

        if (c.getCount() > 0) {
            c.moveToFirst();

            do {
                int id = c.getInt(c.getColumnIndex("id"));
                String tipoDoAnuncio = c.getString(c.getColumnIndex("tipo"));
                String titulo = c.getString(c.getColumnIndex("titulo"));
                String descricao = c.getString(c.getColumnIndex("descricao"));
                String anunciante = c.getString(c.getColumnIndex("anunciante"));
                String contato = c.getString(c.getColumnIndex("contato"));

                byte[] imagemByte = c.getBlob(c.getColumnIndex("imagem"));
                Bitmap imagem = BitmapFactory.decodeByteArray(imagemByte, 0, imagemByte.length);

                Anuncio anuncio = new Anuncio(id, tipoDoAnuncio, titulo, descricao, anunciante, contato);
                anuncio.setImagem(imagem);

                lista.add(anuncio);
            } while (c.moveToNext());
        }
        return lista;
    }
}
