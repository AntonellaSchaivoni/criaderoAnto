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
@Table (name = "galpon")
public class Galpon extends AbstractEntity <Galpon> implements Serializable {
    @Column(name="numero")
    private int numero;
    @Column(name="nombre")
    private String nombre;
    @Column(name="capacidad")
    private int capacidad;
    @Column(name="temperatura")
    private float temperatura;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
    
}
