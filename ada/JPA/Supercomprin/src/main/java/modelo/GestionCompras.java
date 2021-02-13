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
import mx.com.gm.sga.supercomprin.Compra;

/**
 *
 * @author singh
 */
public class GestionCompras {

    public static void alta_compra(Compra c) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
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

    public static void eliminar_compra(int id_compra) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //empezamos la transcción
        tx.begin();
        Compra c = em.find(Compra.class, id_compra);
        //remove del objeto 
        if (c != null) {
            em.remove(c);
        }
        //teminamos la transacción
        tx.commit();
        //cerramos el objeto EntityManeger
        em.close();
    }

    public static List<Compra> recupar_compras() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //empezamos la transcción
        tx.begin();

        //hacermos el Query
        TypedQuery<Compra> qr = em.createNamedQuery("Compra.findAll", Compra.class);

        List<Compra> compras = qr.getResultList();

        //teminamos la transacción
        tx.commit();
        //cerramos el objeto EntityManeger
        em.close();

        return compras;
    }
}