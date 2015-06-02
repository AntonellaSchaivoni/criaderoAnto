/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Administrador
 */
@Entity
@Table (name = "pesaje")
@NamedQueries({
@NamedQuery(name = "pesaje.historial", query = "SELECT p FROM pesaje p WHERE p.cerdo = :cerdo ORDER BY p.fecha"),
@NamedQuery(name = "pesaje.all", query = "SELECT p FROM pesaje p")
})

public class Pesaje extends AbstractEntity <Pesaje> implements Serializable {
    @Column(name="valor")
    private float valor;  
    @Column(name="fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @OneToOne(mappedBy = "cerdo")
    private Cerdo cerdo;

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

    public Cerdo getCerdo() {
        return cerdo;
    }

    public void setCerdo(Cerdo cerdo) {
        this.cerdo = cerdo;
    }
     
}
