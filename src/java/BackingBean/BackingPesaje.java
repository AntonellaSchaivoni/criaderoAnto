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
    private int idcerdo;
    private Cerdo cerdo;

   
   
    
    /*  Atributos para crear nuevo pesaje         */
    private Cerdo idCerdo;
    private float valor;
    private Date fecha;
    private Pesaje pesaje;
    
    public BackingPesaje() {
        pesaje= new Pesaje();
        
    }

    public Pesaje getPesaje() {
        return pesaje;
    }
 public Cerdo getCerdo() {
        return cerdo;
    }

    public void setCerdo(Cerdo cerdo) {
        this.cerdo = cerdo;
    }

    public void setPesaje(Pesaje pesaje) {
        this.pesaje = pesaje;
    }
    
     public int getIdcerdo() {
        return idcerdo;
    }

    public void setIdcerdo(int idcerdo) {
        this.idcerdo = idcerdo;
    }

    public PesajeDAO getPesajeDAO() {
        return pesajeDAO;
    }

    public void setPesajeDAO(PesajeDAO pesajeDAO) {
        this.pesajeDAO = pesajeDAO;
    }

    public Cerdo getIdCerdo() {
        return idCerdo;
    }

    public void setIdCerdo(Cerdo idCerdo) {
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
       public List <Pesaje> getPesajes(){
         return pesajeDAO.getAll();
     }
    
    public List<Pesaje> historialPesaje(int idCerdo){
        Cerdo cerdo = cerdoDAO.buscar(idCerdo);
        return pesajeDAO.historial(cerdo);
    }
    
  //  public List<Pesaje> historialPesaje(int idCerdo){
    //    Cerdo cerdo = cerdoDAO.buscar(idCerdo);
     //   return index?faces-redirect=true;
    //}
    
    
    public String crearPesaje(){
        try{
    
            /*   Almacenamiento en Base de Datos   */
            cerdo = cerdoDAO.buscar(idcerdo);
            pesaje.setIdcerdo(cerdo);
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
