
package model;

import java.io.Serializable;
import java.util.*;
/**
 *
 * @author amrsin
 */
public class listShow implements Serializable{
    
    private ArrayList<show> seriesList;

    public listShow(ArrayList<show> seriesList) {
        this.seriesList = seriesList;
    }
    
    public listShow() {
        
        seriesList = new ArrayList<>();
    }

   public show getShow(int p) {
       
       return seriesList.get(p);
   }
   
   public void setShow(show s){
       
       seriesList.add(s);
   }
   
   public int longitud(){
       return seriesList.size();
   }
   public void delete_s(String t){
       
        show s;
        String aux_titulo;
       	Iterator iter = seriesList.iterator();
        
        while (iter.hasNext()) {           
           
            s = (show) iter.next();
            aux_titulo = s.getTitle();
            
            if (aux_titulo.equalsIgnoreCase(t)) {
                seriesList.remove(s);
                break;
           }   
    }
  }
}