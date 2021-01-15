/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.*;
import mx.com.gm.sga.Usuario;

/**
 *
 * @author amrsin
 */
public class GestionUsuarios {
    //método que permite obtener el objeto EntityManager

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebPU");
        return factory.createEntityManager();
    }

    public boolean autenticar(String usuario, String pwd) {
        EntityManager em = getEntityManager();
        boolean res = false;
        TypedQuery<Usuario> qr = em.createNamedQuery("Usuario.findByUserAndPwd", Usuario.class);
        qr.setParameter(1, usuario);
        qr.setParameter(2, pwd);
        try {
            qr.getSingleResult();
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }
}