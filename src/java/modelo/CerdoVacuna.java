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
@Table(name = "cerdo_vacuna")
public class CerdoVacuna extends AbstractEntity<CerdoVacuna> implements Serializable {

    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @OneToMany(mappedBy = "cerdo")
    private ArrayList<Cerdo> cerdo;
    @OneToMany(mappedBy = "vacuna")
    private ArrayList<Vacuna> vacuna;
    @Column(name = "dosis")
    private float dosis;

    public float getDosis() {
        return dosis;
    }

    public void setDosis(float dosis) {
        this.dosis = dosis;
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

    public ArrayList<modelo.Vacuna> getVacuna() {
        return vacuna;
    }

    public void setVacuna(ArrayList<modelo.Vacuna> vacuna) {
        this.vacuna = vacuna;
    }
}
