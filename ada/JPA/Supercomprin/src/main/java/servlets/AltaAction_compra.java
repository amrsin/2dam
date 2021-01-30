/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionCompras;
import mx.com.gm.sga.supercomprin.Cliente;
import mx.com.gm.sga.supercomprin.Compra;

/**
 *
 * @author singh
 */
@WebServlet("/AltaAction_compra")
public class AltaAction_compra extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String DNI_cliente = request.getParameter("DNI_cliente");
        int id_producto = Integer.parseInt(request.getParameter("id_producto"));
        int Puntos = Integer.parseInt(request.getParameter("puntos"));
        Double Importe = Double.parseDouble(request.getParameter("importe"));

        Date Fecha;

        LocalDate now = LocalDate.now();
        Fecha = Date.valueOf(now);
        //creamos un objeto de la capa de lgica de negocio
        //y llamamos al método encargado de hacer el alta
        GestionCompras gestion_compras = new GestionCompras();
        Cliente client = new Cliente(DNI_cliente);
        Compra c = new Compra(client, id_producto, Fecha, Puntos, Importe);
        gestion_compras.alta_compra(c);
        request.getRequestDispatcher("close.html").forward(request, response);

    }
}
