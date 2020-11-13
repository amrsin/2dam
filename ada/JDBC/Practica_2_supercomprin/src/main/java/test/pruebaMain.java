
package test;

import datos.CompraDAO;
import datos.Conexion;
import domain.Compra;
import java.sql.*;

/**
 *
 * @author singh
 */
public class pruebaMain {
    
    public static void main(String[] args) throws SQLException {
        Connection conexion = Conexion.getConnection();

        try {
            
            if (conexion.getAutoCommit()) {

                conexion.setAutoCommit(false);

            }
            
            String str="2015-03-31";  
            Date date=Date.valueOf(str);  
            CompraDAO compradao = new CompraDAO(conexion);
            
            Compra c = new Compra("123456789", 1, date, 5, 1);
            int registro = compradao.insertar(c);
            conexion.commit();
            

    }catch (SQLException ex) {

            ex.printStackTrace(System.out);
          
    }
    }
}
