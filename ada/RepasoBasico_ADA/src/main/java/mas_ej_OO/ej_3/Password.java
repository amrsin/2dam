/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas_ej_OO.ej_3;

/**
 *
 * @author singh
 */
public class Password {
    
    private int longitud;
    private String pwd;

    public Password() {
        
        longitud = 8;
        pwd = "";
    }

    public Password(int longitud, String pwd) {
        this.longitud = longitud;
        this.pwd = pwd;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public void generarPassword() {
        
        for (int i = 0; i < longitud; i++) {
            
            
            
        }
    }

    
    
    
    
    
}
