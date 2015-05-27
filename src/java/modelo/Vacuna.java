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
@Table(name = "vacuna")
public class Vacuna extends AbstractEntity<Vacuna> implements Serializable {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private String tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
