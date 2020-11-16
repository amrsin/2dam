
package test;

import datos.CompraDAO;
import datos.Conexion;
import domain.Compra;
import java.sql.*;


/**
 *
 * @author amrsin
 */
public class prueba_main {
    
    public static void main(String[] args) throws SQLException {
        Connection conexion = Conexion.getConnection();
        
        System.out.println("hola desde fuera");
        try {

            if (conexion.getAutoCommit()) {

                conexion.setAutoCommit(false);

            }

            String str = "2015-03-31";
            Date date = Date.valueOf(str);
            CompraDAO compradao = new CompraDAO(conexion);

            Compra c = new Compra("123456789", 1, date, 5, 1);

            if (c.getId_producto() == 1) {
                
                System.out.println("Estamos en el if" + c.getId_producto());
                int registro = compradao.insertar(c);

                conexion.rollback();

            }

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

            try {
                conexion.rollback();
            } catch (SQLException ex1) {

                ex1.printStackTrace(System.out);

            }

        }
    }
    
}
