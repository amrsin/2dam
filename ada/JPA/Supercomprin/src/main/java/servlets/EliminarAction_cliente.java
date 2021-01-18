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

import modelo.GestionClientes;
import mx.com.gm.sga.supercomprin.Cliente;

/**
 * Servlet implementation class EliminaContacto
 */
@WebServlet("/EliminarAction_cliente")
public class EliminarAction_cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DNI =(request.getParameter("DNI"));
		GestionClientes gestion_clientes=new GestionClientes();
		gestion_clientes.eliminar_cliente(DNI);
		request.getRequestDispatcher("RecuperarAction_clientes").forward(request, response);
	}
}