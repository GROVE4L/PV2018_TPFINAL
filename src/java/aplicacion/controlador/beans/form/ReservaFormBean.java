package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.DetallePrestamoBean;
import aplicacion.controlador.beans.DetalleReservaBean;
import aplicacion.controlador.beans.PerfilBean;
import aplicacion.controlador.beans.PrestamoBean;
import aplicacion.controlador.beans.PublicacionBean;
import aplicacion.controlador.beans.ReservaBean;
import aplicacion.modelo.dominio.DetallePrestamo;
import aplicacion.modelo.dominio.DetalleReserva;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Prestamo;
import aplicacion.modelo.dominio.Publicacion;
import aplicacion.modelo.dominio.Reserva;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rojas, Guido G.
 */
@ManagedBean
@ViewScoped
public class ReservaFormBean implements Serializable{

    @ManagedProperty(value = "#{reservaBean}")
    private ReservaBean reservaBean;
    
    @ManagedProperty(value = "#{detalleReservaBean}")
    private DetalleReservaBean detalleReservaBean;
    
    private Reserva reserva;
    private DetalleReserva dr;
    private List<Publicacion> listadoAPrestar;
    
    public ReservaFormBean() {
        this.reserva = new Reserva();
        this.dr = new DetalleReserva();        
        this.listadoAPrestar = new ArrayList<Publicacion>();
    }

    public List<Publicacion> getListadoAPrestar() {
        return listadoAPrestar;
    }

    public void setListadoAPrestar(List<Publicacion> listadoAPrestar) {
        this.listadoAPrestar = listadoAPrestar;
    }    

    public ReservaBean getReservaBean() {
        return reservaBean;
    }

    public void setReservaBean(ReservaBean reservaBean) {
        this.reservaBean = reservaBean;
    }

    public DetalleReservaBean getDetalleReservaBean() {
        return detalleReservaBean;
    }

    public void setDetalleReservaBean(DetalleReservaBean detalleReservaBean) {
        this.detalleReservaBean = detalleReservaBean;
    }   

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public DetalleReserva getDr() {
        return dr;
    }

    public void setDr(DetalleReserva dr) {
        this.dr = dr;
    }
    
    public void quitarDeLista(Publicacion pu) {
        System.out.println("Quitado (?");
        this.listadoAPrestar.remove(pu);
    }
    
    public void agregarALista(Publicacion pu) {
        this.listadoAPrestar.add(pu);        
    }
    
    public Reserva obtenerObjReserva() {
        return (Reserva) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("reserva");
    }
    
    public DetalleReserva obtenerObjDetalleReserva() {
        return (DetalleReserva) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("detalleReserva");
    }
    
    public String obtenerNombreSesion(){        
        LoginFormBean lfm = new LoginFormBean();
        Perfil pf = lfm.obtenerPerfilSesion();
        return pf.getPerNombres()+" "+pf.getPerApellidos();
    }
    
    public String cargarLibros(){
        LoginFormBean lfm = new LoginFormBean();
        this.reserva.setRevEstado(true);
        this.reserva.setRevFechaEmision(new Date());
        this.reserva.setRevPerfil(lfm.obtenerPerfilSesion().getPerCodigo());
        /*System.out.println("Objeto Reserva");
        System.out.println("Fecha Emision "+reserva.getRevFechaEmision());
        System.out.println("Estado "+reserva.isRevEstado());
        System.out.println("Fecha de turno: "+reserva.getRevFechaTurno());
        System.out.println("Usuario Solicitante: "+reserva.getRevPerfil());*/
        
        this.listadoAPrestar=null;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("detalleReserva", this.dr);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("reserva", this.reserva);
        return "cargarReservaLibros?faces-redirect=true";
    }
}
