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
public class Serie implements Formatacao {

     private int id;
     private String nome;
     private String[] genero;
     private String faixaEtaria;
     private String cover;
     private String dataLancamento;
     private String sinopse;
     private String descricao;

     public Serie(){
          this.nome = "";
          this.dataLancamento = "";
          this.faixaEtaria = "";
          this.genero = new String[5];
          this.sinopse = "";
          this.cover = "";
     }

     public Serie(int id, String nome, String[] genero, String faixaEtaria, String cover, String dataLancamento, String sinopse, String descricao){
          this.id = id;
          this.nome = nome;
          this.dataLancamento = dataLancamento;
          this.faixaEtaria = faixaEtaria;
          this.genero = genero;
          this.sinopse = sinopse;
          this.cover = cover;
          this.descricao = descricao;
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

     public String getSinopse(){
          return this.sinopse;
     }
     
     public int getId(){
         return this.id;
     }
    
    @Override
    public String gerarStringDoGenero(){
        return "Algumacoisa";
    }
    
}
