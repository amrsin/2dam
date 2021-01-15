/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author amrsin
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionContactos;
import mx.com.gm.sga.Contacto;

/**
 * Servlet implementation class AltaContacto
 */
@WebServlet("/AltaAction")
public class AltaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String email=request.getParameter("email");
		String telefono=request.getParameter("telefono");
		//creamos un objeto de la capa de lgica de negocio
		//y llamamos al método encargado de hacer el alta
		GestionContactos gcontactos=new GestionContactos();
                Contacto c = new Contacto(nombre, email, telefono);
		gcontactos.alta_contacto(c);
		request.getRequestDispatcher("menu.html").forward(request, response);
	}
}