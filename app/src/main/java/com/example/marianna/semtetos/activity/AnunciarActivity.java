package com.example.marianna.semtetos.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marianna.semtetos.R;
import com.example.marianna.semtetos.dao.AnuncioDAO;
import com.example.marianna.semtetos.model.Anuncio;

public class AnunciarActivity extends AppCompatActivity {

    private EditText titulo;
    private EditText tipo;
    private EditText descricao;
    private EditText anunciante;
    private EditText telefone;
    private Button btnInserir;
    private AnuncioDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anunciar);

        this.titulo = (EditText) findViewById(R.id.anuncioTitulo);
        this.tipo = (EditText) findViewById(R.id.anuncioTipo);
        this.descricao = (EditText) findViewById(R.id.anuncioDescricao);
        this.anunciante = (EditText) findViewById(R.id.anuncioAnunciante);
        this.telefone = (EditText) findViewById(R.id.anuncioTelefone);
        this.btnInserir = (Button) findViewById(R.id.btnInserir);

        this.dao = new AnuncioDAO(this);

        this.btnInserir.setOnClickListener(new OnClickBotao());
    }


    public class OnClickBotao implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v.equals(AnunciarActivity.this.btnInserir)) {
                String titulo = AnunciarActivity.this.titulo.getText().toString();
                String tipo = AnunciarActivity.this.tipo.getText().toString();
                String descricao = AnunciarActivity.this.descricao.getText().toString();
                String anunciante = AnunciarActivity.this.anunciante.getText().toString();
                String telefone = AnunciarActivity.this.telefone.getText().toString();

                Anuncio anuncio = new Anuncio(tipo,titulo,descricao,anunciante,telefone);

                AnunciarActivity.this.dao.insert(anuncio);

                Log.i("Anuncio", AnunciarActivity.this.dao.get().toString());
            }
        }
    }
}
