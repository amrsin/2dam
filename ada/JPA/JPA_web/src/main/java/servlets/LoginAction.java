
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.GestionUsuarios;

/**
 *
 * @author amrsin
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        GestionUsuarios gusuarios = new GestionUsuarios();
        if (gusuarios.autenticar(user, pwd)) {
            //guardamos el nombre de usuario en un atributo de sesión
            HttpSession s = request.getSession();
            s.setAttribute("user", user);
            request.getRequestDispatcher("menu.html").forward(request, response);
        } else {
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }
}