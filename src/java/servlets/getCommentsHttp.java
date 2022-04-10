/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import JDBC.ConnectionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Comentario;
import models.Usuarios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author rapha
 */
public class getCommentsHttp extends HttpServlet {
    ConnectionFactory conn;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>GetComentsServlet</h1>");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int idMov = Integer.parseInt(request.getParameter("idMov"));
        conn = new ConnectionFactory();

        ArrayList<Comentario> comentarios = conn.obterComentarios(idMov);

        for(Comentario com: comentarios) {
            Usuarios user = conn.getUserById(com.getIdUser());
            out.println(
                "<div id='row__vStart' style='margin-top: 2.5vh;'>" +
                    "<img src='" + user.getAvatar() + "' class='avatar__user__img'>" +
                    "<div class='coments__bar full_width' style='margin-left: 1.5vh; align-items: flex-start;'>" +
                        "<h1 class='color_grey none__marginTop'>" + user.getNome() + "</h1>" +
                        "<p class='color_grey'>" + com.getComentario() + "</p>" +
                "</div> </div>"
            );
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
