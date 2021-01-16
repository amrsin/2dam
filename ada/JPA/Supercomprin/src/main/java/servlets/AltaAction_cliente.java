package servlets;

/**
 *
 * @author amrsin
 */
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionClientes;
import mx.com.gm.sga.supercomprin.Cliente;


@WebServlet("/AltaAction_cliente")
public class AltaAction_cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                String DNI=request.getParameter("DNI");
                String Nombre=request.getParameter("nombre");
                String Apellidos=request.getParameter("apellidos");
		String Email=request.getParameter("email");
                String Fecha_nacimento_str = request.getParameter("fecha_nacimiento");
                
                java.util.Date Fecha_util;
                java.sql.Date Fecha_nacimiento = null;
                
            try {
                Fecha_util = new SimpleDateFormat("yyyy-MM-dd").parse(Fecha_nacimento_str);
                Fecha_nacimiento =  new java.sql.Date(Fecha_util.getTime());

            } catch (ParseException ex) {
                Logger.getLogger(AltaAction_cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
                
		//creamos un objeto de la capa de lgica de negocio
		//y llamamos al método encargado de hacer el alta
		GestionClientes g_clieCliente =new GestionClientes();
                Cliente c = new Cliente(DNI, Nombre, Apellidos, Email, Fecha_nacimiento);
		g_clieCliente.alta_cliente(c);
                
                request.getRequestDispatcher("new_cliente.html").forward(request, response);

	}
}