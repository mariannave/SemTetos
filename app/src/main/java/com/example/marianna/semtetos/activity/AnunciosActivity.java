package com.example.marianna.semtetos.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.marianna.semtetos.R;
import com.example.marianna.semtetos.adapters.AnuncioAdapter;
import com.example.marianna.semtetos.dao.AnuncioDAO;
import com.example.marianna.semtetos.model.Anuncio;

import java.util.List;

/**
 * Created by joffily on 08/04/17.
 */

public class AnunciosActivity extends AppCompatActivity {

    ListView anunciosList;
    List<Anuncio> anuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_anuncios);

        this.anunciosList = (ListView) this.findViewById(R.id.anuncioList);

        AnuncioDAO anuncioDAO = new AnuncioDAO(this);
        this.anuncios = anuncioDAO.get();


        AnuncioAdapter ra = new AnuncioAdapter(this, this.anuncios);
        this.anunciosList.setAdapter(ra);

        Log.i("Anuncio", this.anuncios.toString());

    }
}
