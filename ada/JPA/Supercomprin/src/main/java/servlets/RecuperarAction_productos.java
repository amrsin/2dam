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
import modelo.GestionProductos;
import mx.com.gm.sga.supercomprin.Producto;

/**
 *
 * @author singh
 */

@WebServlet("/RecuperarAction_productos")
public class RecuperarAction_productos extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestionProductos gestion_productos = new GestionProductos();

        List<Producto> productos = gestion_productos.recupar_productos();
        //guardamos contactos en un atributo de peticion
        request.setAttribute("productos", productos);
        //trasnferencia de la peticion
        request.getRequestDispatcher("productos.jsp").forward(request, response);
    }
}