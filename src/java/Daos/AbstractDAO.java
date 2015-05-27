/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

/**
 *
 * @author HP1140LA
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Ger!
 */
@PersistenceUnit(unitName = "PU")

public abstract class  AbstractDAO <T> {
    @PersistenceContext
    protected  EntityManager em;
    private Class<T> entityClass;

    public AbstractDAO(Class classType) {
        this.entityClass = classType;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) throws Exception{
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Long id) {
        return getEntityManager().find(entityClass, id);
    }
    
    

}

