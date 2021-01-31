/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionDevueltos;
import mx.com.gm.sga.supercomprin.Devuelve;

/**
 *
 * @author singh
 */
@WebServlet("/RecuperarAction_devueltos")
public class RecuperarAction_devueltos extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestionDevueltos gestion_devueltos = new GestionDevueltos();

        List<Devuelve> devueltos = gestion_devueltos.recupar_devueltos();
        //guardamos contactos en un atributo de peticion
        request.setAttribute("devueltos", devueltos);
        //trasnferencia de la peticion
        request.getRequestDispatcher("devueltos.jsp").forward(request, response);
    }
}
