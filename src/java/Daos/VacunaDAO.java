/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Vacuna;

/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class VacunaDAO extends AbstractDAO <Vacuna>{

    
     public VacunaDAO() {
        super(Vacuna.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
                return em;
    }
    

       public List<Vacuna> getAll (){
        Query query = em.createNamedQuery("Vacuna.findAll");	 
        return query.getResultList(); 
    
       }
    
}
