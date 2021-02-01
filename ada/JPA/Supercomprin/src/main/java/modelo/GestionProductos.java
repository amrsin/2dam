/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import mx.com.gm.sga.supercomprin.Producto;

/**
 *
 * @author singh
 */
public class GestionProductos {
    
     public static List<Producto> recupar_productos() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //empezamos la transcción
        tx.begin();

        //hacermos el Query
        TypedQuery<Producto> qr = em.createNamedQuery("Producto.findAll", Producto.class);

        List<Producto> productos = qr.getResultList();

        //teminamos la transacción
        tx.commit();
        //cerramos el objeto EntityManeger
        em.close();

        return productos;
    }   
}