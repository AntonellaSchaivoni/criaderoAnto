/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.CerdoDAO;
import Daos.GalponCerdoDAO;
import Daos.GalponDAO;
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

    public BackingCerdo() {
    }
    
    public Cerdo buscarCerdo(Long id) {
        return cerdoDAO.find(id);     
    }
    
    public String eliminarCerdo(Long id) {
        try {
            Cerdo cerdo = cerdoDAO.find(id);
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
    public String moverCerdo(Long idCerdo, Long idGalpon){
        try {
            Cerdo cerdo = cerdoDAO.find(idCerdo);
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
