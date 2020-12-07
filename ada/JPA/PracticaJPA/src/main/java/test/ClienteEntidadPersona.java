
package test;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;
/**
 *
 * @author amrsin
 */
public class ClienteEntidadPersona {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Empezamos la transacción
        tx.begin();
        //nuevo objeto que vamos a insertar en la tala persona no ponemos id porque es AI
        Persona p = new Persona("Maria", "Pérez", "Maria@gmail.com", 20);
        log.debug("Objeto a persistir es " + p);
        //persistimos el objeto
        em.persist(p);
        //teminamos la transacción
        tx.commit();
        log.debug("Objeto persistido: " + p);
        //cerramos el objeto EntityManeger
        em.close();
        
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        p.setNombre("Maria Pepa");
        p.setEmail("maria_perez@gmail.com");
        em.merge(p);
        tx.commit();
        em.close();         
    }   
}