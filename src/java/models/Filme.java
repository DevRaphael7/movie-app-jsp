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
    private String screenshot;
    
    public Filme(String nome, String cover, String[] genero){
        this.nome = nome;
        this.cover = cover;
        this.genero = genero;
        this.faixaEtaria = "";
        this.dataLancamento = "";
        this.screenshot = "";
    }

    public Filme(String nome, String[] genero, String cover, String faixaEtaria, String dataLancamento, String screenshot){
        this.nome = nome;
        this.genero = genero;
        this.cover = cover;
        this.faixaEtaria = faixaEtaria;
        this.dataLancamento = dataLancamento;
        this.screenshot = screenshot;
    }

    public Filme(String nome, String[] genero, String cover, String faixaEtaria, String dataLancamento){
        this.nome = nome;
        this.genero = genero;
        this.cover = cover;
        this.faixaEtaria = faixaEtaria;
        this.dataLancamento = dataLancamento;
        this.screenshot = "";
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

    public String getScreenshot(){
        return this.screenshot;
    }
 
}
