/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author rapha
 */
public class Usuarios {
  
    private int idUsuario;  
    private String nome;
    private String password;
    private String avatar;
    private String email;

    public Usuarios(String nome, String password, String email, String avatar){
        this.nome = nome;
        this.password = password;
        this.avatar = avatar;
        this.email = email;
    }

    public Usuarios(String nome, String password) {
        this.nome = nome;
        this.password = password;
        this.idUsuario = 0;
        this.avatar = "";
        this.email = "";
    }

    public Usuarios() {
        this.nome = "";
        this.password = "";
        this.avatar = "";
        this.email = "";
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id){
       this.idUsuario = id;  
    }

    public int getId(){
       return this.idUsuario;
    }
}
