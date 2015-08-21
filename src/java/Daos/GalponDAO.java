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
import modelo.Galpon;
import modelo.GalponCerdo;

/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class GalponDAO extends AbstractDAO<Galpon> {

    public GalponDAO() {
        super(Galpon.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Galpon> getAll() {
        Query query = em.createNamedQuery("Galpon.findAll");    
        return  query.getResultList();

    }

    
    
}