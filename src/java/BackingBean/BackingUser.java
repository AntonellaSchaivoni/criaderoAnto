/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.UserDAO;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.User;

/**
 *
 * @author Sandoval
 */
@ManagedBean
@SessionScoped
public class BackingUser {
     private User user;
     @EJB
     private UserDAO userDAO;
    
    
    public BackingUser() {
        this.user=new User();
    }
    
     public String login(){
       if(userDAO.login(user.getUsername(), user.getPassword())){
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("usuario", user);
            return ""; //pagina bienvenida
            
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Usuario y/o Contraseña incorrectos"));
            return ""; //retorna al login nuevamente
        }
        
    }
}
