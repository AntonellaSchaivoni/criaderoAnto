/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.CerdoDAO;
import Daos.GalponCerdoDAO;
import Daos.GalponDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Cerdo;
import modelo.GalponCerdo;


/**
 *
 * @author Islas, Juan Pablo
 */

@ManagedBean
@SessionScoped
public class BackingCerdo {
    
    @EJB
    private GalponDAO galponDAO;
    @EJB
    private CerdoDAO cerdoDAO;
    @EJB
    private GalponCerdoDAO galponCerdo;
    
    private Cerdo cerdo;
    
    public BackingCerdo(){
        cerdo= new Cerdo();
    }
    public Cerdo getCerdo() {
        return cerdo;
    }
    public void setCerdo(Cerdo cerdo) {
        this.cerdo = cerdo;
    }      
     public List <Cerdo> getCerdos(){
         return cerdoDAO.getAll();
     }
     public String agregarCerdo() {
        try {
           
            cerdoDAO.create(cerdo);
           FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El cerdo fué agregado exitosamente"));
            return "/admin/Cerdo/index.xhtml"; //retorna al listado de galpones
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al agregar el cerdo"));
            return "/admin/Cerdo/newCerdo.xhtml"; //retorna al form de creacion del galpon
        }
     }
    public Cerdo buscarCerdo(int id) {
        return cerdoDAO.buscar(id);     
    }
        
    public String eliminarCerdo(int id) {
        try {
             cerdo = cerdoDAO.buscar(id);
            /*  El cerdo no debería ser eliminado    */            
            cerdoDAO.remove(cerdo);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El cerdo fué eliminado exitosamente"));
            return "";
        } catch (Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al eliminar el cerdo"));
            return "";
        }
    }
    
    /**
     * 
     * 
     * @param idCerdo : Numero de id del cerdo a buscar.
     *        idGalpon : Numero de id del galpón al cual es movido el cerdo.
     * @return String : Retorna mensaje de confirmación o de error del sistema. 
     */
    public String moverCerdo(int idCerdo, int idGalpon){
        try {
            Cerdo cerdo = cerdoDAO.buscar(idCerdo);
            GalponCerdo gc = galponCerdo.galponActual(idCerdo);
            
            /*  Eliminar cerdo de gc             */
            /*  Agregar fecha de eliminacion     */
            /*  Agregar cerdo a nuvo galpon      */
            
            cerdoDAO.edit(cerdo);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El cerdo fué cambiado de galpon exitosamente."));
            return "";
        } catch(Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al mover el cerdo" 
                                                      + e.getMessage()));
            return "";
        }
    }
    
 
}
