/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series;

import model.access;
import model.listShow;
import model.show;

/**
 *
 * @author amrsin
 */
public class Series {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        //create an instance of one serie:
        
        /*show sh = new show("Breaking Bad", "Vicent Guilligan", 5, "Drama", 5);
        //create a list:
        listShow ls = new listShow();
        //add the serie:
        ls.setShow(sh);
        //create second serie:
        sh = new show("JGame of thrones", "David Benioff", 6, "1", 6);
        ls.setShow(sh);
        //save it in a file
        access.saveLS(ls);
        System.out.println("saved series");
          */
        
        listShow ls = new listShow();
        //read file
        ls = access.loadLS();
        //create a serie
        show sh = new show();
        //obtain first element of aratList;
        sh=ls.getShow(0);
        //get the title
        System.out.print("title: ");
        System.out.println(sh.getTitle());
        //obtain secound element:
        
        sh = ls.getShow(1);
        System.out.print("title: ");
        System.out.println(sh.getTitle());
        
    }
    
}
