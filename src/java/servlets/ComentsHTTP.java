/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import JDBC.ConnectionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import models.Usuarios;
import servlets.interfaces.HttpRequests;

/**
 *
 * @author rapha
 */
public class ComentsHTTP extends HttpServlet {
    ConnectionFactory conection;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>Coments servlet</h1>");
    };
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        conection = new ConnectionFactory();
        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("password");
        String id_mov = request.getParameter("idFilme");
        String coment = request.getParameter("comentUser");

        Usuarios user = conection.getUserDB(new Usuarios(usuario, senha));
        out.println(user.getId());
        Boolean enviadoAoBanco = conection.adicionarComentario(coment, user.getId(), Integer.parseInt(id_mov));

        if(enviadoAoBanco){
            out.println("<h1>Armazenado com sucesso!</h1>");
        } else {
            out.println("<h1>Ops, ocorreu algum erro! + " + response.getStatus() + user.getId() + "</h1>");
        }
    };
}
