/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.*;
import javax.persistence.Persistence;
import javax.xml.registry.infomodel.PersonName;
import mx.com.gm.sga.Contacto;

/**
 *
 * @author amrsin
 */
public class GestionContactos {
    
    
    
    
    public static void alta_contacto(Contacto c) {
       
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
       EntityManager em = emf.createEntityManager();
       EntityTransaction tx = em.getTransaction();
       
       //empezamos la transcción
       tx.begin();
       //persistimos el objeto     
       em.persist(c);
       //teminamos la transacción
       tx.commit();
       //cerramos el objeto EntityManeger
       em.close();
   
    }
    
    public static void eliminar_contacto(Contacto c) {
       
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
       EntityManager em = emf.createEntityManager();
       EntityTransaction tx = em.getTransaction();
       
       //empezamos la transcción
       tx.begin();
       //remove del objeto     
       em.remove(c);
       //teminamos la transacción
       tx.commit();
       //cerramos el objeto EntityManeger
       em.close();
    }
    
     public static List<Contacto> recupar_contactos(Contacto c) {
       
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
       EntityManager em = emf.createEntityManager();
       EntityTransaction tx = em.getTransaction();
       
       //empezamos la transcción
       tx.begin();
       //remove del objeto     
       em.remove(c);
       //teminamos la transacción
       tx.commit();
       //cerramos el objeto EntityManeger
       em.close();
        return null;
    }
}