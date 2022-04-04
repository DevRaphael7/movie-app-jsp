/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package components;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Filme;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import JDBC.ConnectionFactory;

/**
 *
 * @author rapha
 */
public class SerchTxtFieldHttpRequest extends HttpServlet {
    ConnectionFactory conection;
    Filme mov;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>SearchMovie Servlet!</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String valorRequest = request.getParameter("value");

        response.setContentType("text/html;charset=UTF-8");

        conection = new ConnectionFactory();

        PrintWriter out = response.getWriter();

        ArrayList<Filme> filmeSearch = new ArrayList<>();

        filmeSearch = conection.getMoviesDataBase(
            "SELECT * FROM filmes WHERE genero LIKE '%" + valorRequest.toLowerCase() + "%'" +
            "|| nome LIKE '%" + valorRequest.toLowerCase() + "%'" +
            "|| SUBSTRING_INDEX(data_lancamento, '-', 0) = '" + valorRequest.toLowerCase() + "' LIMIT 4"
        );
    
        ArrayList<Filme> serieSearch = conection.getMoviesDataBase(
           "SELECT * from series WHERE " +
           "nome LIKE '%" + valorRequest + "%' || " +
           "genero LIKE '%" + valorRequest + "%' LIMIT 4;"
        );
        
        if(serieSearch.size() != 0){
            for(int i = 0; i < serieSearch.size(); i++){
                filmeSearch.add(serieSearch.get(i));
            }  
        } 

        if(filmeSearch.size() == 0) return;

        for(Filme item: filmeSearch){
            out.println(
                "<a href='http://localhost:8080/projeto_faculdade/src/page/DetailPage.jsp?idM=" + item.getId() + "&nomeM=" + item.getNome() + "'" +
                    " style='text-decoration: none; color: #FFF;'>" +
                    "<div style='display: flex;" +
                        "padding: 5px;" +  
                        "align-items: center;' class='card__search__bar'>" + 
                        "<img src='" + item.getCover() + "' style='" +
                            "width: 60px;" +
                            "height: 60px;" +
                            "object-fit: cover;" +
                            "border-radius: 12px;" +
                        "'>" +
                        "<div style='margin-left: 10px'>" + 
                            "<p id='nomeFilme'>" + item.getNome() + "</p>" +
                            "<p id='nomeGenero'>" + item.gerarStringDoGenero() + "</p>" +
                        "</div>" +
                    "</div>" +
                "</a>"
            );
        }
    }

    @Override
    public String getServletInfo() {
        return "Servidor de busca de filmes para a searchbar";
    }// </editor-fold>
    
    

}
