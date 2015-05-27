/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table (name = "cerdo")
public class Cerdo extends AbstractEntity <Cerdo> implements Serializable {
    @Column(name="sexo")
    private float sexo;
    @Column(name="clasificacion")
    private float clasificacion;
    @OneToMany(mappedBy = "galpon")
    private ArrayList<Galpon> galpon;

    public float getSexo() {
        return sexo;
    }

    public void setSexo(float sexo) {
        this.sexo = sexo;
    }

    public float getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(float clasificacion) {
        this.clasificacion = clasificacion;
    }

    public ArrayList<Galpon> getGalpon() {
        return galpon;
    }

    public void setGalpon(ArrayList<Galpon> galpon) {
        this.galpon = galpon;
    }
    
    
}
