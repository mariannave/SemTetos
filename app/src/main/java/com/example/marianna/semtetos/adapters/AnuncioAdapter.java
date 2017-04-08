package com.example.marianna.semtetos.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marianna.semtetos.R;
import com.example.marianna.semtetos.model.Anuncio;

import java.util.List;

/**
 * Created by joffily on 08/04/17.
 */

public class AnuncioAdapter extends BaseAdapter {

    Context context;
    List<Anuncio> lista;

    public AnuncioAdapter(Context context, List<Anuncio> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return this.lista.size();
    }

    @Override
    public Object getItem(int i) {
        return this.lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater li = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.celula_anuncio, null);
        }

        ImageView imagem = (ImageView) view.findViewById(R.id.fotoAnuncio);
        TextView tv = (TextView) view.findViewById(R.id.anuncio_titulo_id);

        Anuncio anuncio = this.lista.get(i);
        
        tv.setText(anuncio.getTitulo() + ", " + anuncio.getAnunciante() + " " + anuncio.getContato() );
        imagem.setImageBitmap(this.lista.get(i).getImagem());

        return view;
    }
}
