/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Ger!
 */

@MappedSuperclass
public abstract class AbstractEntity<T>  {
   private static final long serialVersionUID = 1L;
   @Id 
   @GeneratedValue(generator = "id" ,strategy = GenerationType.SEQUENCE)
   protected Long id;
   
    @Override
    public int hashCode() {
         int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity<T> other = (AbstractEntity<T>) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
   
    @Override
    public String toString() {
        return "modelo.AbstractEntity[ abstractEntity=" + id + " ]";
    }
}
