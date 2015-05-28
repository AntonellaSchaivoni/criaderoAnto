/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Daos.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "user")
@NamedQueries({
@NamedQuery(name = "usuario.exist", query = "Select u from User u where u.username= :username and u.password= :password")})
public class User extends AbstractEntity<User> implements Serializable {
    
    @Column(name="username")
    private String username; 
    @Column(name="password")
    private String password;  

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    
}
