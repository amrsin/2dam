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
import modelo.GestionCompras;
import mx.com.gm.sga.supercomprin.Compra;

/**
 *
 * @author singh
 */
@WebServlet("/RecuperarAction_compras")
public class RecuperarAction_compras extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestionCompras gestion_compras = new GestionCompras();

        List<Compra> compras = gestion_compras.recupar_compras();
        //guardamos contactos en un atributo de peticion
        request.setAttribute("compras", compras);
        //trasnferencia de la peticion
        request.getRequestDispatcher("compras.jsp").forward(request, response);
    }
}