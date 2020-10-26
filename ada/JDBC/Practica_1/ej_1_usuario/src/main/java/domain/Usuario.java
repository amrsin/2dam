
package domain;

/**
 *
 * @author singh
 */
public class Usuario {

    //variables
    private int id_usuario;
    private String usr;
    private String password;

    //constructor por defecto 
    public Usuario() {

        id_usuario = 0;
        usr = "";
        password = "";
    }

    //constructor con solo id
    public Usuario(int id_usuario) {

        this.id_usuario = id_usuario;

    }

    //constructor con todos los datos
    public Usuario(int id_usuario, String usr, String password) {
        this.id_usuario = id_usuario;
        this.usr = usr;
        this.password = password;
    }

    //getters y setters de cada variable
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //metodo toString 
    @Override
    public String toString() {
        return "Id usuario: " + id_usuario + ", User: " + usr + ", Password: " + password;
    }
}
