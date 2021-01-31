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
import mx.com.gm.sga.supercomprin.Devuelve;

/**
 *
 * @author singh
 */
public class GestionDevueltos {

    public static void alta_devuelve(Devuelve d) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //empezamos la transcción
        tx.begin();
        //persistimos el objeto     
        em.persist(d);
        //teminamos la transacción
        tx.commit();
        //cerramos el objeto EntityManeger
        em.close();

    }

    public static List<Devuelve> recupar_devueltos() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //empezamos la transcción
        tx.begin();

        //hacermos el Query
        TypedQuery<Devuelve> qr = em.createNamedQuery("Devuelve.findAll", Devuelve.class);

        List<Devuelve> devueltos = qr.getResultList();

        //teminamos la transacción
        tx.commit();
        //cerramos el objeto EntityManeger
        em.close();

        return devueltos;
    }
}
