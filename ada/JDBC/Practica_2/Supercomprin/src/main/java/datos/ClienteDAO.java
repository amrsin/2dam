package datos;

import domain.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author singh
 */
public class ClienteDAO {

    private static final String SQL_SELECT = "SELECT * FROM Cliente";
    private static final String SQL_SELECT_DNI = "SELECT * FROM Cliente WHERE DNI = ?";
    private static final String SQL_INSERT = "INSERT INTO Cliente VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM Cliente where DNI = ?";
    private static final String SQL_UPDATE = "UPDATE Cliente SET Nombre = ?, Apellidos = ?, Email = ?, Fecha_nacimiento =?, Puntos =?, Saldo =? WHERE DNI = ?";
    private static final String SQL_UPDATE_PUNTOS = "UPDATE cliente SET Puntos = ? WHERE DNI = ?";
    private static final String SQL_UPDATE_SALDO= "UPDATE cliente SET Saldo = ? WHERE DNI = ?";


    private Connection conexionTrasaccional;

    public ClienteDAO(Connection conexionTrasaccional) {

        this.conexionTrasaccional = conexionTrasaccional;

    }

    //metodo para hacer select y guardar los datos en list
    public List<Cliente> select() {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente c = null;
        List<Cliente> list_clientes = new ArrayList<>();

        try {
             //get connection si conexionTrasaccional es null
             con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_SELECT); //indicamos la consulta a hacer
            rs = stmt.executeQuery(); //ejecutamos la consulta
            //mientras tengamos obejetos en resultSet
            //creando Objeto Usuario y lo agregamos en list_clientes
            while (rs.next()) {

                String DNI = rs.getString("DNI");
                String Nombre = rs.getString("Nombre");
                String Apellidos = rs.getString("Apellidos");
                String Email = rs.getString("Email");
                Date Fecha_nacimiento = rs.getDate("Fecha_nacimiento");
                int puntos = rs.getInt("Puntos");
                double Saldo = rs.getDouble("Saldo");
                c = new Cliente(DNI, Nombre, Apellidos, Email, Fecha_nacimiento, puntos, Saldo);
                list_clientes.add(c);
            }
        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        } finally {

            try {

                Conexion.close(rs); //cerramos resultSet
                Conexion.close(stmt); //cerramos statament
                if (conexionTrasaccional == null) {

                    Conexion.close(con);

                }

            } catch (SQLException ex) {

                ex.printStackTrace(System.out);

            }
        }
        return list_clientes;
    }
    //metodo para selecte segun DNI
    public Cliente select_DNI(Cliente c_aux) {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente c = null;
        

        try {
            //get connection si conexionTrasaccional es null
             con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_SELECT_DNI); //indicamos la consulta a hacer
            stmt.setString(1, c_aux.getDNI());
            rs = stmt.executeQuery(); //ejecutamos la consulta
            //mientras tengamos obejetos en resultSet
            //creando Objeto Usuario y lo agregamos en list_clientes
            while (rs.next()) {

                String DNI = rs.getString("DNI");
                String Nombre = rs.getString("Nombre");
                String Apellidos = rs.getString("Apellidos");
                String Email = rs.getString("Email");
                Date Fecha_nacimiento = rs.getDate("Fecha_nacimiento");
                int puntos = rs.getInt("Puntos");
                double Saldo = rs.getDouble("Saldo");
                c = new Cliente(DNI, Nombre, Apellidos, Email, Fecha_nacimiento, puntos, Saldo);                
            }
        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        } finally {

            try {

                Conexion.close(rs); //cerramos resultSet
                Conexion.close(stmt); //cerramos statament
                if (conexionTrasaccional == null) {

                    Conexion.close(con);

                }

            } catch (SQLException ex) {

                ex.printStackTrace(System.out);
            }
        }
        return c;
    }

    //metodo para insertar
    public int insert(Cliente c) throws SQLException {

        //var
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            //get connection si conexionTrasaccional es null
            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_INSERT);//consulta
            //identificamos los ? segun la consulta
            stmt.setString(1, c.getDNI());
            stmt.setString(2, c.getNombre());
            stmt.setString(3, c.getApellidos());
            stmt.setString(4, c.getEmail());
            stmt.setDate(5, c.getFecha_nacimineto());
            stmt.setInt(6, c.getPuntos());
            stmt.setDouble(7, c.getSaldos());

            registros = stmt.executeUpdate();

            //si registros es distinto 0 es que se ha insetado cliente bien, sino algo ha fallado
            if (registros != 0) {

                System.out.println("Se ha agregado a la bd el cliente con DNI " + c.getDNI());
            } else {

                System.out.println("Ha habido fallo a la hora de insertar el cliente");
            }
            //cerramos la conecion
        } finally {
            try {
                Conexion.close(stmt);//cerramos stmt
                if (conexionTrasaccional == null) {

                    Conexion.close(con);

                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    //metodo para eliminar
    public int delete(Cliente c) throws SQLException {

        //var
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_DELETE);//consulta
            //identificamos ? segun la consulta
            stmt.setString(1, c.getDNI());
            registros = stmt.executeUpdate();
            
            //si registros es distinto 0 es que se ha eliminado cliente bien, sino algo ha fallado
            if (registros != 0) {

                System.out.println("Se ha eliminado de la bd el cliente con DNI " + c.getDNI());
            } else {

                System.out.println("Ha habido fallo a la hora de eliminar el cliente");
            }
            //cerramos la conecion
        } finally {
            try {
                Conexion.close(stmt);//cerramos stmt
                if (conexionTrasaccional == null) {

                    Conexion.close(con);

                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    //metodo para actualizar 
    public int update(Cliente c) throws SQLException {

        //var
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_UPDATE);//consulta
            //identificamos los ? segun la consulta
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getApellidos());
            stmt.setString(3, c.getEmail());
            stmt.setDate(4, c.getFecha_nacimineto());
            stmt.setInt(5, c.getPuntos());
            stmt.setDouble(6, c.getSaldos());
            stmt.setString(7, c.getDNI());
            registros = stmt.executeUpdate();
            //si registros es distinto 0 es que se ha actualizado cliente bien, sino algo ha fallado
            if (registros != 0) {

                System.out.println("Se han actualizado datos del cliente con DNI " + c.getDNI());
            } else {

                System.out.println("Ha habido fallo a la hora de actualizar datos del cliente");
            }
            //cerramos la conecion
        } finally {
            try {
                Conexion.close(stmt);//cerramos stmt
                if (conexionTrasaccional == null) {

                    Conexion.close(con);

                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    //metodo para actualizar puntos
    public int update_puntos(Cliente c) throws SQLException {

        //var
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_PUNTOS);//consulta
            //identificamos los ? segun la consulta
            stmt.setInt(1, c.getPuntos());
            stmt.setString(2, c.getDNI());
            registros = stmt.executeUpdate();
            //si registros es distinto 0 es que se ha actualizado cliente bien, sino algo ha fallado
            if (registros != 0) {

                System.out.println("Se han actualizado datos del cliente con DNI " + c.getDNI());
            } else {

                System.out.println("Ha habido fallo a la hora de actualizar datos del cliente");
            }
            //cerramos la conecion
        } finally {
            try {
                Conexion.close(stmt);//cerramos stmt
                if (conexionTrasaccional == null) {

                    Conexion.close(con);

                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    //metodo para actualizar puntos
    public int update_saldo(Cliente c) throws SQLException {

        //var
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_SALDO);//consulta
            //identificamos los ? segun la consulta
            stmt.setDouble(1, c.getSaldos());
            stmt.setString(2, c.getDNI());
            registros = stmt.executeUpdate();
            //si registros es distinto 0 es que se ha actualizado cliente bien, sino algo ha fallado
            if (registros != 0) {

                System.out.println("Se ha recargado cuenta cliente " + c.getDNI());
            } else {

                System.out.println("Ha habido fallo a la hora de recargar");
            }
            //cerramos la conecion
        } finally {
            try {
                Conexion.close(stmt);//cerramos stmt
                if (conexionTrasaccional == null) {

                    Conexion.close(con);

                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}