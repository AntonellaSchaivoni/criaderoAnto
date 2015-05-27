/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Administrador
 */
@Entity
@Table (name = "cerdo_enfermedad")
public class CerdoEnfermedad extends AbstractEntity <CerdoEnfermedad> implements Serializable {
     @OneToMany(mappedBy = "cerdo")
    private ArrayList<Cerdo> cerdo;
     @OneToMany(mappedBy = "enfermedad")
    private ArrayList<Enfermedad> enfermedad;
     @Column(name="f_ini")
     @Temporal(javax.persistence.TemporalType.DATE)
    private Date f_ini;
     @Temporal(javax.persistence.TemporalType.DATE)
     @Column(name="f_fin")
      private Date f_fin;

    public ArrayList<Cerdo> getCerdo() {
        return cerdo;
    }

    public void setCerdo(ArrayList<Cerdo> cerdo) {
        this.cerdo = cerdo;
    }

    public ArrayList<Enfermedad> getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(ArrayList<Enfermedad> enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Date getF_ini() {
        return f_ini;
    }

    public void setF_ini(Date f_ini) {
        this.f_ini = f_ini;
    }

    public Date getF_fin() {
        return f_fin;
    }

    public void setF_fin(Date f_fin) {
        this.f_fin = f_fin;
    }
     
     
}
