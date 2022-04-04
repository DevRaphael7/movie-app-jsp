/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package components;

import JDBC.ConnectionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;

import models.Usuarios;

/**
 *
 * @author rapha
 */
public class CadastroHttp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>User cad</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        
        String usuario = request.getParameter("user");
        String senha = request.getParameter("password");
        String email = request.getParameter("email");

        ConnectionFactory conn = new ConnectionFactory();
        String avatar = "https://observatoriodocinema.uol.com.br/wp-content/uploads/2021/12/avatar-1200x900-1.jpg";
        Boolean resultCad = conn.cadUser(new Usuarios(usuario, senha, email, avatar));

        if(resultCad){
            out.println(resultCad);
        } else {
            out.println("Error");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
