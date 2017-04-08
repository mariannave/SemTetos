package com.example.marianna.semtetos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.marianna.semtetos.R;

public class MainActivity extends AppCompatActivity {
    private Button btnAnunciar;
    private Button btnAnuncios;
    private Button btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnAnunciar = (Button) findViewById(R.id.btnAnunciar);
        this.btnAnuncios = (Button) findViewById(R.id.btnAnuncios);
        this.btnSobre = (Button) findViewById(R.id.btnSobre);

        this.btnSobre.setOnClickListener(new OnClickBotao());
        this.btnAnunciar.setOnClickListener(new OnClickBotao());
        this.btnAnuncios.setOnClickListener(new OnClickBotao());

    }


    public class OnClickBotao implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v.equals(MainActivity.this.btnSobre)) {
                Intent it = new Intent(MainActivity.this, SobreActivity.class);
                startActivity(it);
            } else if(v.equals(MainActivity.this.btnAnunciar)) {
                Intent it = new Intent(MainActivity.this, AnunciarActivity.class);
                startActivity(it);

            } else if(v.equals(MainActivity.this.btnAnuncios)) {
                Intent it = new Intent(MainActivity.this, AnunciosActivity.class);
                startActivity(it);
            }
        }
    }
}
