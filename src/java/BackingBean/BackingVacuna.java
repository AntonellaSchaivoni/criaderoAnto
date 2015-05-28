/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.VacunaDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Vacuna;

/**
 *
 * @author Sandoval
 */
@ManagedBean
@SessionScoped
public class BackingVacuna {

   private Vacuna vacuna;

  
   @EJB
   private VacunaDAO vacunaDAO;
   
    public BackingVacuna() {
    }
    
      public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }
    public List listarVacunas(){
        return vacunaDAO.getAll();
    }
    
    public String crearVacuna(){
        try{
            vacunaDAO.create(vacuna);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("La vacuna fué creada exitosamente"));
            return ""; //retorna al listado de vacunas
        }catch(Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al crear vacuna"));
            return ""; //retorna al form de creacion de vacuna
        }
    }
}
