package com.example.marianna.semtetos.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marianna.semtetos.R;
import com.example.marianna.semtetos.dao.AnuncioDAO;
import com.example.marianna.semtetos.model.Anuncio;

public class AnunciarActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 30;
    private EditText titulo;
    private EditText tipo;
    private EditText descricao;
    private EditText anunciante;
    private EditText telefone;
    private Button btnInserir;
    private AnuncioDAO dao;
    private Button tiraFotoBtn;
    private Bitmap imagemTirada;

    // Captura o resultado da Intent
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGE_CAPTURE) {
            Bundle extras = data.getExtras();
            Bitmap imagem = (Bitmap) extras.get("data");
            imagemTirada = (Bitmap) extras.get("data");
//            photo.setImageBitmap(imagem);
            Log.i("PhotoBomb", "Imagem tirada com sucesso!");
        }
    }

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
        this.tiraFotoBtn = (Button) findViewById(R.id.tiraFotoBtn);

        this.dao = new AnuncioDAO(this);

        this.btnInserir.setOnClickListener(new OnClickBotao());
        this.tiraFotoBtn.setOnClickListener(new OnClickBotao());
    }


    // Chama a Intent da camera
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
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
                Bitmap imagem = AnunciarActivity.this.imagemTirada;

                Anuncio anuncio = new Anuncio(tipo,titulo,descricao,anunciante,telefone);
                anuncio.setImagem(imagem);

                AnunciarActivity.this.dao.insert(anuncio);

                Log.i("Anuncio", AnunciarActivity.this.dao.get().toString());
                Intent it = new Intent();
                setResult(RESULT_OK, it);
                finish();
            } else if (v.equals(AnunciarActivity.this.tiraFotoBtn)) {
                dispatchTakePictureIntent();
            }
        }
    }
}
