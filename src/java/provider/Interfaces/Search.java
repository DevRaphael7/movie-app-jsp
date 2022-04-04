/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package provider.Interfaces;

import java.util.ArrayList;
import models.Filme;
import models.Serie;

/**
 *
 * @author rapha
 */
public interface Search {

    public ArrayList<Filme> searchMovieByGenre(String genero, ArrayList<Filme> movies);
    public ArrayList<Serie> searchSerieByGenre(String genero, ArrayList<Serie> serie);
    
}
