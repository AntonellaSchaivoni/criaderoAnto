/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.CerdoDAO;
import Daos.PesajeDAO;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Cerdo;
import modelo.Pesaje;

/**
 *
 * @author Islas, Juan Pablo
 */
@ManagedBean
@SessionScoped
public class BackingPesaje {
    @EJB
    private PesajeDAO pesajeDAO;
    @EJB
    private CerdoDAO cerdoDAO;
    
    /*  Atributos para crear nuevo pesaje         */
    private Long idCerdo;
    private float valor;
    private Date fecha;
    
    public BackingPesaje() {
    }

    public PesajeDAO getPesajeDAO() {
        return pesajeDAO;
    }

    public void setPesajeDAO(PesajeDAO pesajeDAO) {
        this.pesajeDAO = pesajeDAO;
    }

    public Long getIdCerdo() {
        return idCerdo;
    }

    public void setIdCerdo(Long idCerdo) {
        this.idCerdo = idCerdo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public List<Pesaje> historialPesaje(Long idCerdo){
        Cerdo cerdo = cerdoDAO.find(idCerdo);
        return pesajeDAO.historial(cerdo);
    }
    
    public String crearPesaje(){
        try{
            Cerdo cerdo = cerdoDAO.find(idCerdo);
            /*   Inicializacion de cerdo   */
            Pesaje pesaje = new Pesaje();
            pesaje.setCerdo(cerdo);
            pesaje.setFecha(fecha);
            pesaje.setValor(valor);

            /*   Almacenamiento en Base de Datos   */
            pesajeDAO.create(pesaje);
            
            /*   Mensaje de exito   */
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El pesaje fue almacenado."));
            return "";
        } catch(Exception e){
            /*   Mensaje de error   */
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al eliminar el pesaje."));
            return "";
        }
    }
}
