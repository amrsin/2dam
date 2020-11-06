
package domain;

import java.sql.*;

/**
 *
 * @author singh
 */
public class Persona {
    
    private int id_persona;
    private String nombre;
    private String apellidos;
    private int edad;
    private String email;

    public Persona() {
       
        id_persona = 0;
        nombre = "";
        apellidos = "";
        edad = 0;
        email = "";
    }
    
    public Persona(int id_persona) {
        
        this.id_persona = id_persona;
   
    }

    public Persona(String nombre, String apellidos, String email, int edad) {
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.edad = edad;
    }

    public Persona(int id_persona, String nombre, String apellidos, String email, int edad) {
        
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.edad = edad;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    

    @Override
    public String toString() {
        return "Id persona: " + id_persona + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Email :" + email + ", Edad: " + edad ;
    }
}
