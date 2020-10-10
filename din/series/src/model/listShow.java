
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
   
      public show find_show(String t){
       
        show s;
        show aux = null;
        String aux_titulo;
       	Iterator iter = seriesList.iterator();
        
        
        while (iter.hasNext()) {           
           
            s = (show) iter.next();
            aux_titulo = s.getTitle();
            
            if (aux_titulo.equalsIgnoreCase(t)) {
               
               aux = s;
                
            
           }   
    } 
        return aux;
  }
      
      public void modify(show s, String title, 
      String screenwriter, int season, String genre, int seen_season) {
      
        
      /*s.setTitle(title);
      s.setScriptwriter(screenwriter);
      s.setSeasons(season);
      s.setGenere(genre);
      s.setViews(seen_season);
      System.out.println(s.getTitle() + s.getScriptwriter() + s.getSeasons() + s.getGenere() 
           + s.getViews());*/
      
      
      	Iterator iter = seriesList.iterator();
      while (iter.hasNext()) {           
           
          show s1;
            s1 = (show) iter.next();
            
             System.out.println(s.getTitle() + s.getScriptwriter() + s.getSeasons() + s.getGenere() 
           + s.getViews());

            /*if (s1.equals(s)) {
             s.setTitle(title);
             s.setScriptwriter(screenwriter);
             s.setSeasons(season);
             s.setGenere(genre);
             s.setViews(seen_season);
             System.out.println("hola");*/
          }
             
           
      
      }   
      }