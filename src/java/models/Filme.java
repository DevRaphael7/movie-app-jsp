/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import models.Interfaces.Formatacao;

/**
 *
 * @author rapha
 */
public class Filme implements Formatacao {
    
    private int id;
    private String nome;
    private String[] genero;
    private String faixaEtaria;
    private String cover;
    private String dataLancamento;
    private String sinopse;
    private String descricao;
    
    public Filme(String nome, String[] genero, String faixaEtaria, String dataLancamento){
        this.nome = nome;
        this.cover = "";
        this.genero = genero;
        this.faixaEtaria = faixaEtaria;
        this.dataLancamento = dataLancamento;
    }

    public Filme(int id, String nome, String[] genero, String cover, String faixaEtaria, String dataLancamento, String sinopse, String descricao){
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.cover = cover;
        this.faixaEtaria = faixaEtaria;
        this.dataLancamento = dataLancamento;
        this.sinopse = sinopse;
        this.descricao = descricao;
    }
    public int getId(){
        return this.id;
    }

    public String getNome() {
        return this.nome;          
    }
    
    public String[] getGenero() {
        return this.genero;
    }

    public String getFaixaEtaria() {
        return this.faixaEtaria;
    }

    public String getCover() {
        return this.cover;
    }

    public String getDataLancamento() {
        return this.dataLancamento;
    }
    
    @Override
    public String gerarStringDoGenero() {
        String generos = "";
        for(int i = 0; i < this.genero.length; i++){
            generos += this.genero[i];

            if(i + 1 != genero.length){
                generos += ", ";
            }
        }

        return generos;
    }

    public String getSinopse(){
        return this.sinopse;
    }

    public String getDescricao() {
        return this.descricao;
    }
 
}
