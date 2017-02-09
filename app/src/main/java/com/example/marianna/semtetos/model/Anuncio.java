package com.example.marianna.semtetos.model;

/**
 * Created by Marianna on 08/02/2017.
 */

public class Anuncio {

    private int id;
    private String tipoDoAnuncio;
    private String titulo;
    private String descricao;
    private String anunciante;
    private String contato;
    private String imagemURL;


    public Anuncio(String tipoDoAnuncio, String titulo, String descricao, String anunciante, String contato) {
        this.tipoDoAnuncio = tipoDoAnuncio;
        this.titulo = titulo;
        this.descricao = descricao;
        this.anunciante = anunciante;
        this.contato = contato;
    }

    public Anuncio(int id, String tipoDoAnuncio, String titulo, String descricao, String anunciante, String contato) {
        this.id = id;
        this.tipoDoAnuncio = tipoDoAnuncio;
        this.titulo = titulo;
        this.descricao = descricao;
        this.anunciante = anunciante;
        this.contato = contato;
    }

    public String getTipoDoAnuncio() {
        return tipoDoAnuncio;
    }

    public void setTipoDoAnuncio(String tipoDoAnuncio) {
        this.tipoDoAnuncio = tipoDoAnuncio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(String anunciante) {
        this.anunciante = anunciante;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getImagemURL() {
        return imagemURL;
    }

    public void setImagemURL(String imagemURL) {
        this.imagemURL = imagemURL;
    }

}
