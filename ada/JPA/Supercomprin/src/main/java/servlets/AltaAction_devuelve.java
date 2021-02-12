/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionClientes;
import modelo.GestionDevueltos;
import modelo.GestionProductos;
import mx.com.gm.sga.supercomprin.Cliente;
import mx.com.gm.sga.supercomprin.Devuelve;
import mx.com.gm.sga.supercomprin.Producto;

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
        int id_producto = Integer.parseInt(request.getParameter("id_producto"));
        //int Puntos = Integer.parseInt(request.getParameter("puntos"));
        //Double Importe = Double.parseDouble(request.getParameter("importe"));
        Date Fecha;
        LocalDate now = LocalDate.now();
        Fecha = Date.valueOf(now);
        GestionClientes gestion_clientes = new GestionClientes();
        GestionProductos gestion_productos = new GestionProductos();

        //si no existe dni_cliente en bd lanza alert
        if (!gestion_clientes.find_cliente(DNI_cliente)) {

            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('DNI no existe en bd');");
            pw.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("new_devuelve.html");
            rd.include(request, response);
        //si no existe id_producto en bd lanza alert
        } else if (gestion_productos.find_producto(id_producto) == null) {

            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Producto no existe en bd');");
            pw.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("new_devuelve.html");
            rd.include(request, response);

        }
        //si todo bien hace alta devolucion
        //creamos un objeto de la capa de lgica de negocio
        //y llamamos al método encargado de hacer el alta
        GestionDevueltos gestion_devueltos = new GestionDevueltos();
        Cliente client = new Cliente(DNI_cliente);
        Producto p = gestion_productos.find_producto(id_producto);
        Devuelve d = new Devuelve(client, id_producto, Fecha, p.getPuntos(), p.getPrecio());
        gestion_devueltos.alta_devuelve(d);
        request.getRequestDispatcher("close.html").forward(request, response);
    }
}