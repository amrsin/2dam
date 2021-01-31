
package servlets;

/**
 *
 * @author singh
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        String url = "";
        switch (op) {
            case "doAlta_cliente":
                url = "AltaAction_cliente";
                break;
            case "doUpdate_cliente":
                url = "UpdateAction_cliente";
                break;
            case "doEliminar_cliente":
                url = "EliminarAction_cliente";
                break;
            case "doRecuperar_cliente":
                url = "RecuperarAction_clientes";
                break;
            
            case "doAlta_compra":
                url = "AltaAction_compra";
                break;
            
            case "doEliminar_compra":
                url = "EliminarAction_compra";
                break;
 
           case "doRecuperar_compra":
                url = "RecuperarAction_compras";
                break;
                
            case "doAlta_devuelve":
                url = "AltaAction_devuelve";
                break;
            
           case "doRecuperar_devuelve":
                url = "RecuperarAction_devueltos";
                break;
            
            case "toMenu":
                url = "menu.html";
                break;
            
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}