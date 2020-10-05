
package model;

import java.io.Serializable;
import java.util.ArrayList;

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
   
   public int longuitud(){
       return seriesList.size();
   }
    
}