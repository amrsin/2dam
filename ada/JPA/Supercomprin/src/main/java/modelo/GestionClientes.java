package modelo;

import java.util.List;
import javax.persistence.*;
import javax.persistence.Persistence;
import mx.com.gm.sga.supercomprin.Cliente;

/**
 *
 * @author amrsin
 */
public class GestionClientes {
    
   
    public static void alta_cliente(Cliente c) {
       
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
    
    public static void eliminar_cliente(String DNI) {
       
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
       EntityManager em = emf.createEntityManager();
       EntityTransaction tx = em.getTransaction();
       
       
       //empezamos la transcción
       tx.begin();
       Cliente c = em.find(Cliente.class, DNI);
       //remove del objeto 
       if(c!=null){
	  em.remove(c);
	}
       //teminamos la transacción
       tx.commit();
       //cerramos el objeto EntityManeger
       em.close();
    }
    
     public static List<Cliente> recupar_clientes() {
       
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
       EntityManager em = emf.createEntityManager();
       EntityTransaction tx = em.getTransaction();
       
      
       //empezamos la transcción
       tx.begin();
       
       //hacermos el Query
       TypedQuery<Cliente> qr = em.createNamedQuery("Cliente.findAll",Cliente.class);
       
       List<Cliente> clientes = qr.getResultList();
       
       //teminamos la transacción
       tx.commit();
       //cerramos el objeto EntityManeger
       em.close();
        
      return clientes;
    }
     
     
    public void update_cliente(Cliente c) {
        
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
       EntityManager em = emf.createEntityManager();
       EntityTransaction tx = em.getTransaction();

       //empezamos la transcción
       tx.begin();

       TypedQuery<Cliente> qr = em.createNamedQuery("Cliente.update", Cliente.class);
       
        qr.setParameter(1, c.getNombre());
        qr.setParameter(2, c.getApellidos());
        qr.setParameter(3, c.getEmail());
        qr.setParameter(4, c.getFecha_nacimiento());
        qr.setParameter(5, c.getDNI());
                
        qr.executeUpdate();
        //teminamos la transacción
        tx.commit();
        //cerramos el objeto EntityManeger
        em.close();


        
    } 
}