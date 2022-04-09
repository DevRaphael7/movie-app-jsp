/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servlets.interfaces;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author rapha
 */
public interface HttpRequests {

    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
}
