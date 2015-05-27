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
@Table (name = "pesaje")
public class Pesaje extends AbstractEntity <Pesaje> implements Serializable {
    @Column(name="valor")
    private float valor;  
     @Column(name="fecha")
 @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
     @OneToMany(mappedBy = "cerdo")
    private ArrayList<Cerdo> cerdo;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
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
