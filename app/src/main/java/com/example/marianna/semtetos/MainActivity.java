package com.example.marianna.semtetos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

    }



    public class OnClickBotao implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            
        }
    }
}
