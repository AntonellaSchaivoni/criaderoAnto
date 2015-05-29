/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Daos.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Administrador
 */
@Entity
@Table (name = "galpon_cerdo")
@NamedQueries({
@NamedQuery(name = "galponcerdo.galponactual", query = "select gc from galponcerdo gc where gc.cerdo = :cerdo AND gc.f_fin = NULL ")})

public class GalponCerdo extends Galpon {
    @OneToMany(mappedBy = "galpon")
    private ArrayList<Galpon> galpon;
    @OneToMany(mappedBy = "cerdo")
    private ArrayList<Cerdo> cerdo;
    @Column(name="f_ini")
     @Temporal(javax.persistence.TemporalType.DATE)
    private Date f_ini;
     @Temporal(javax.persistence.TemporalType.DATE)
     @Column(name="f_fin")
     private Date f_fin;

    public Date getF_fin() {
        return f_fin;
    }

    public void setF_fin(Date f_fin) {
        this.f_fin = f_fin;
    }

    public ArrayList<Galpon> getGalpon() {
        return galpon;
    }

    public void setGalpon(ArrayList<Galpon> galpon) {
        this.galpon = galpon;
    }

    public ArrayList<Cerdo> getCerdo() {
        return cerdo;
    }

    public void setCerdo(ArrayList<Cerdo> cerdo) {
        this.cerdo = cerdo;
    }

    public Date getF_ini() {
        return f_ini;
    }

    public void setF_ini(Date f_ini) {
        this.f_ini = f_ini;
    }
     
    
}
