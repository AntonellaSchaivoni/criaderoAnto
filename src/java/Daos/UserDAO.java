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
import modelo.User;

/**
 *
 * @author Administrador
 */
@Stateless

@LocalBean
public class UserDAO extends AbstractDAO <User>{

    
     public UserDAO() {
        super(User.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
                return em;
    }
    

       public List<User> getAll (){
        Query query = em.createNamedQuery("User.all");
	List <User> usuario = query.getResultList(); 
        return usuario;
    
       }
    
}
