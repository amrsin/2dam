package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelo.GestionClientes;
import mx.com.gm.sga.supercomprin.Cliente;


/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarAction_Clientes")
public class RecuperarAction_Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                GestionClientes gclientes = new GestionClientes();
		List<Cliente> clientes =gclientes.recupar_clientes();
		//guardamos contactos en un atributo de peticion
		request.setAttribute("clientes", clientes);
		//trasnferencia de la peticion
		request.getRequestDispatcher("clientes.jsp").forward(request, response);
	}
}