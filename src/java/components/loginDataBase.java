/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package components;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import JDBC.ConnectionFactory;
import jakarta.servlet.http.Cookie;
import models.Usuarios;

/**
 *
 * @author rapha
 */
public class loginDataBase extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>SearchMovie Servlet!</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        String usuarioEmail = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        if(usuarioEmail.isEmpty() || senha.isEmpty()){
            out.println("<p>Usuário ou senha inválidos</p>");
            return;
        }

        Usuarios user = new Usuarios(usuarioEmail, senha);
        ConnectionFactory conn = new ConnectionFactory();

        String query = "SELECT * FROM usuario WHERE nome = '" + user.getNome() + "' && senha = '" + user.getPassword() + "'";

        int usuarioCadastrado = conn.getLoginDataBase(user, query);

        if(usuarioCadastrado != -1){
            Cookie nomeUsurio = new Cookie("nome", usuarioEmail);
            Cookie senhaUsuario = new Cookie("senha", senha);
            response.addCookie( nomeUsurio );
            response.addCookie( senhaUsuario );
            nomeUsurio.setMaxAge(60*60*24); 
            senhaUsuario.setMaxAge(60*60*24);
            out.println("-1");
        } else {
            out.println("Usuário inválido ou não cadastrado!");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
