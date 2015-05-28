/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.CerdoDAO;
import Daos.GalponDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Cerdo;
import modelo.Galpon;
import modelo.GalponCerdo;

/**
 *
 * @author Sandoval
 */
@ManagedBean
@SessionScoped
public class BackingGalpon {

    private GalponCerdo galpon;
    private Cerdo cerdo;
    @EJB
    private GalponDAO galponDAO;
    @EJB
    private CerdoDAO cerdoDAO;

    public BackingGalpon() {
        this.galpon = new GalponCerdo();
    }

    public GalponCerdo getGalpon() {
        return galpon;
    }

    public void setGalpon(GalponCerdo galpon) {
        this.galpon = galpon;
    }

    public Cerdo getCerdo() {
        return cerdo;
    }

    public void setCerdo(Cerdo cerdo) {
        this.cerdo = cerdo;
    }

    public List getGalpones() {
        return galponDAO.getAll();
    }

    public List getCerdosGalpon(long idGalpon) {
        galpon = galponDAO.find(idGalpon);
        return galpon.getCerdo();
    }

    public String eliminarCerdo(long id) {
        try {
            cerdo = cerdoDAO.find(id);
            galpon.getCerdo().remove(cerdo);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El cerdo fué eliminado exitosamente"));
            return ""; //retorna al listado de cerdos del galp{on 
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al eliminar el cerdo"));
            return ""; //retorna al listado de cerdos del galpon
        }
    }

    public String agregarGalpon() {
        try {
            galponDAO.create(galpon);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El galpon fué creado exitosamente"));
            return ""; //retorna al listado de galpones
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al crear el galpon"));
            return ""; //retorna al form de creacion del galpon
        }

    }

    public String agregarCerdoAGalpon(long idGalpon) {
        try {
            GalponCerdo galponCerdo = galponDAO.find(idGalpon);
            cerdoDAO.create(cerdo);
            galponCerdo.getCerdo().add(cerdo);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El cerdo fué agregado al galpon"));
            return ""; //retorna al listado de los cerdos del galpon
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al agregar el cerdo al galpón"));
            return ""; //retorna al formulario de creacion de cerdos
        }
    }
    
    public List listarGalpones(){
        return galponDAO.getAll();
    }
}
