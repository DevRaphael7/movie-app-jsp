/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author rapha
 */
public class Comentario {

    private int id;
    private int idUser;
    private int idFilme;
    private String comentario;

   public Comentario(){
       this.id = 0;
       this.idFilme = 0;
       this.idUser = 0;
       this.comentario = "";
   }

   public Comentario(int id, int idUser, int idFilme, String coment){
        this.id = id;
        this.idUser = idUser;
        this.idFilme = idFilme;
        this.comentario = coment;
   }

   public int getId(){
       return this.id;
   }

    public int getIdUser() {
        return this.idUser;
    }

    public int getIdFilme(){
        return this.idFilme;
    }

    public String getComentario(){
        return this.comentario;
    }
}
