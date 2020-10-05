
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author amrsin
 */
public class access {
    
    private static File f = new File("series.dat");
    
    public static void saveLS(listShow ls) {
        
        try {
            
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(ls);
            oos.close();
        } catch (Exception e) {
            
            System.out.println("Failed to open file");
        }
    }
    
    public static listShow loadLS() {
        
        listShow ls = new listShow();
        ObjectInputStream ois = null;
        
        try {
            FileInputStream fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ls=(listShow) ois.readObject();
            ois.close();
            
        } catch (Exception e) {
            
            System.out.println("Failed to open file");
        }finally{
        
            return ls;
        }   
    }
}
