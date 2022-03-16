/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author rapha
 */
public class Search {

    private ArrayList<Filme> movies;
    private ArrayList<String> genero;
    
    public Search(ArrayList<Filme> movies, ArrayList<String> genero) {
        this.movies = movies;
        this.genero = genero;
    }

    public ArrayList<Filme> searchMovieByMovie(String genero) {
        ArrayList<Filme> novaListaDeFilmes = new ArrayList<>();

        for(int i =0; i< movies.size(); i++){
            for(String genreMov: movies.get(i).getGenero()){
                System.out.println(genero + " " + genreMov);
                if(genreMov.contains(genero)){
                    novaListaDeFilmes.add(movies.get(i));
                }
            }
        }
        return novaListaDeFilmes;
    }
}
