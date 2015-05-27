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
import modelo.TieneParto;

/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class TienePartoDAO extends AbstractDAO <TieneParto>{

    
     public TienePartoDAO() {
        super(TieneParto.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
                return em;
    }
    

       public List<TieneParto> getAll (){
        Query query = em.createNamedQuery("tiene_parto.all");
	List <TieneParto> tiene = query.getResultList(); 
        return tiene;
    
       }
    
}