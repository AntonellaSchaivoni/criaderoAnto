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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Administrador
 */
@Entity
@Table (name = "parto")
public class Parto extends AbstractEntity <Parto> implements Serializable {
 @Column(name="num_parto")
    private int numParto;    
  @Column(name="cant_chancho")
    private int cantChancho;
   @Column(name="cant_muertos")
    private int cantMuertos;
    @Column(name="fecha")
 @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @OneToMany(mappedBy = "cerdo")
    private ArrayList<Cerdo> cerdo;

    public int getNumParto() {
        return numParto;
    }

    public void setNumParto(int numParto) {
        this.numParto = numParto;
    }

    public int getCantChancho() {
        return cantChancho;
    }

    public void setCantChancho(int cantChancho) {
        this.cantChancho = cantChancho;
    }

    public int getCantMuertos() {
        return cantMuertos;
    }

    public void setCantMuertos(int cantMuertos) {
        this.cantMuertos = cantMuertos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Cerdo> getCerdo() {
        return cerdo;
    }

    public void setCerdo(ArrayList<Cerdo> cerdo) {
        this.cerdo = cerdo;
    }
    
    
}
