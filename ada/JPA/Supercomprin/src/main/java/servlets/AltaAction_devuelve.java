/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionDevueltos;
import mx.com.gm.sga.supercomprin.Cliente;
import mx.com.gm.sga.supercomprin.Devuelve;

/**
 *
 * @author singh
 */
@WebServlet("/AltaAction_devuelve")
public class AltaAction_devuelve extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String DNI_cliente = request.getParameter("DNI_cliente");
        int id_devuelve = Integer.parseInt(request.getParameter("id_devuelve"));
        int Puntos = Integer.parseInt(request.getParameter("puntos"));
        Double Importe = Double.parseDouble(request.getParameter("importe"));

        Date Fecha;

        LocalDate now = LocalDate.now();
        Fecha = Date.valueOf(now);
        //creamos un objeto de la capa de lgica de negocio
        //y llamamos al método encargado de hacer el alta
        GestionDevueltos gestion_devueltos = new GestionDevueltos();
        Cliente client = new Cliente(DNI_cliente);
        Devuelve d = new Devuelve(client, id_devuelve, Fecha, Puntos, Importe);
        gestion_devueltos.alta_devuelve(d);
        request.getRequestDispatcher("close.html").forward(request, response);
    }
}
