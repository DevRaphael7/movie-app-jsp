/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provider;

import java.util.ArrayList;
import models.Filme;
import models.Serie;

/**
 *
 * @author rapha
 */
public class Search implements provider.Interfaces.Search {
    
    public Search() {}
    
    @Override
    public ArrayList<Filme> searchMovieByGenre(String genero, ArrayList<Filme> movies) {
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
    
    @Override
    public ArrayList<Serie> searchSerieByGenre(String genero, ArrayList<Serie> serie) {
        ArrayList<Serie> novaListaDeSeries = new ArrayList<>();

        for(int i =0; i < serie.size(); i++){
            for(String genreSer: serie.get(i).getGenero()){
                if(genreSer.contains(genero)){
                    novaListaDeSeries.add(serie.get(i));
                }
            }
        }

        return novaListaDeSeries;
    }
}
