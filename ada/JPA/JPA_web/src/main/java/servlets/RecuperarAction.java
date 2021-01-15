package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelo.GestionContactos;
import mx.com.gm.sga.Contacto;


/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarAction")
public class RecuperarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionContactos gcontacto = new GestionContactos();
                
		List<Contacto> contactos=gcontacto.recupar_contactos();
		//guardamos contactos en un atributo de peticion
		request.setAttribute("contactos", contactos);
		//trasnferencia de la peticion
		request.getRequestDispatcher("contactos.jsp").forward(request, response);
	}
}