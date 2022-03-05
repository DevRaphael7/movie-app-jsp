/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author rapha
 */
public class Filme {
    
    private String nome;
    private String[] genero;
    private String faixaEtaria;
    private String cover;
    private String dataLancamento;
    
    public Filme(){}

    public Filme(String nome, String[] genero, String cover, String faixaEtaria, String dataLancamento){
        this.nome = nome;
        this.genero = genero;
        this.cover = cover;
        this.faixaEtaria = faixaEtaria;
        this.dataLancamento = dataLancamento;
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

    public String gerarStringDoGenero(String[] generos) {
        String genero = "";

        for(int i = 0; i < generos.length; i++){
            genero += generos[i];

            if(i + 1 != generos.length){
                genero += ", ";
            }
        }

        return genero;
    }
 
}
