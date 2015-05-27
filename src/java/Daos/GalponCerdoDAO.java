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
import modelo.GalponCerdo;

/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class GalponCerdoDAO extends AbstractDAO <GalponCerdo>{

    
     public GalponCerdoDAO() {
        super(GalponCerdo.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
                return em;
    }
    

       public List<GalponCerdo> getAll (){
        Query query = em.createNamedQuery("galpn_cerdo.all");
	List <GalponCerdo> galponcerdos = query.getResultList(); 
        return galponcerdos;
    
       }
    
}