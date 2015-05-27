/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Daos.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table (name = "enfermedad")
public class Enfermedad extends AbstractEntity <Enfermedad> implements Serializable {
    @Column(name="nombre_cientifico")
    private String nombreCientifico;
    @Column(name="nombre_popular")
    private String nombrePopular;

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombrePopular() {
        return nombrePopular;
    }

    public void setNombrePopular(String nombrePopular) {
        this.nombrePopular = nombrePopular;
    }
    
    
    
}
