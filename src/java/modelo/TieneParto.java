/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Daos.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "tiene_parto")
public class TieneParto extends AbstractEntity<TieneParto> implements Serializable {

    @OneToOne(mappedBy = "cerdo")
    private Cerdo esCria;
    @OneToOne(mappedBy = "cerdo")
    private Cerdo esProg;
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    public Cerdo getEsCria() {
        return esCria;
    }

    public void setEsCria(Cerdo esCria) {
        this.esCria = esCria;
    }

    public Cerdo getEsProg() {
        return esProg;
    }

    public void setEsProg(Cerdo esProg) {
        this.esProg = esProg;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
