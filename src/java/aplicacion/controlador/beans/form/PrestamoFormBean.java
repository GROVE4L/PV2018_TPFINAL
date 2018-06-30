package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.DetallePrestamoBean;
import aplicacion.controlador.beans.PerfilBean;
import aplicacion.controlador.beans.PrestamoBean;
import aplicacion.controlador.beans.PublicacionBean;
import aplicacion.modelo.dominio.DetallePrestamo;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Prestamo;
import aplicacion.modelo.dominio.Publicacion;
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
public class PrestamoFormBean implements Serializable{

    @ManagedProperty(value = "#{prestamoBean}")
    private PrestamoBean prestamoBean;
    
    @ManagedProperty(value = "#{detallePrestamoBean}")
    private DetallePrestamoBean detallePrestamoBean;
    
    private Prestamo prestamo;
    private DetallePrestamo dp;
    private List<Publicacion> listadoAPrestar;
    
    public PrestamoFormBean() {
        this.prestamo = new Prestamo();
        this.dp = new DetallePrestamo();
        dp.setDpTurno("Mañana");
        this.listadoAPrestar = new ArrayList<Publicacion>();
    }

    public List<Publicacion> getListadoAPrestar() {
        return listadoAPrestar;
    }

    public void setListadoAPrestar(List<Publicacion> listadoAPrestar) {
        this.listadoAPrestar = listadoAPrestar;
    }    
    
    public PrestamoBean getPrestamoBean() {
        return prestamoBean;
    }

    public void setPrestamoBean(PrestamoBean prestamoBean) {
        this.prestamoBean = prestamoBean;
    }

    public DetallePrestamoBean getDetallePrestamoBean() {
        return detallePrestamoBean;
    }

    public void setDetallePrestamoBean(DetallePrestamoBean detallePrestamoBean) {
        this.detallePrestamoBean = detallePrestamoBean;
    }

    public DetallePrestamo getDp() {
        return dp;
    }

    public void setDp(DetallePrestamo dp) {
        this.dp = dp;
    }
    
    public void borrarPrestamo(Prestamo objPrestamo) {        
        List<DetallePrestamo> listaLibros = this.devolverDetallePrestamosCodigo(objPrestamo.getPreCodigo());
        PublicacionBean pBean = new PublicacionBean();
        Publicacion objPubAux = new Publicacion();
        for(DetallePrestamo i: listaLibros) {
            objPubAux.setPubCodigo(i.getDpPublicacion());
            objPubAux = pBean.buscarPublicacion(objPubAux);
            objPubAux.setPubStock(objPubAux.getPubStock()+1);
            pBean.modificarPublicacion(objPubAux);
            detallePrestamoBean.borrarDetallePrestamo(i);
        }        
        prestamoBean.borrarPrestamo(objPrestamo);
        FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Prestamo eliminado!",
                            ""));
    }
    
    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {        
        this.prestamo = prestamo;
    }
    
    public Prestamo obtenerObjPrestamo() {
        return (Prestamo) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("prestamo");
    }
    
    public DetallePrestamo obtenerObjDetallePrestamo() {
        return (DetallePrestamo) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("detallePrestamo");
    }
    
    public void quitarDeLista(Publicacion pu) {
        this.listadoAPrestar.remove(pu);
    }
    
    public void agregarALista(Publicacion pu) {
        this.listadoAPrestar.add(pu);        
    }
    
    public List<Prestamo> listarPrestamos() {
        return prestamoBean.listarPrestamos();
    }
    
    public List<DetallePrestamo> devolverDetallePrestamosCodigo(int codigoBuscado) {
        return detallePrestamoBean.devolverDetallePrestamosCodigo(codigoBuscado);        
    }
    
    public String obtenerNombrePrestamoDirecto(int codigoPerfilBuscado){        
        PerfilBean pb = new PerfilBean();
        Perfil pf = pb.obtenerPerfilDirecto(codigoPerfilBuscado);
        return pf.getPerNombres()+" "+pf.getPerApellidos();
    }
    
    public String obtenerNombrePrestamo(){        
        PerfilBean pb = new PerfilBean();
        Perfil pf = pb.obtenerPerfilDirecto(((Prestamo) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("prestamo")).getPreSocio());
        return pf.getPerNombres()+" "+pf.getPerApellidos();
    }
    
    
    public List<Perfil> obtenerPerfilesFinales() {
        PerfilBean perfilBean = new PerfilBean();        
        return perfilBean.obtenerPerfilesEspecificos("final");
    }
    
    public String finalizarPrestamo() {
        if(!this.listadoAPrestar.isEmpty()){
            Prestamo objPrestamo = this.obtenerObjPrestamo();
            DetallePrestamo objDetallePrestamo = this.obtenerObjDetallePrestamo();
            prestamoBean.agregarPrestamo(objPrestamo);
            
            objDetallePrestamo.setDpEstado(true);
            objDetallePrestamo.setDpFechaDevolucion(new Date(1999, 9, 9));
            objDetallePrestamo.setDpPrestamo(prestamoBean.obtenerUltimoPrestamo().getPreCodigo());

            PublicacionBean pb = new PublicacionBean();
            for(Publicacion i: this.listadoAPrestar) {
                objDetallePrestamo.setDpPublicacion(i.getPubCodigo());
                detallePrestamoBean.agregarDetallePrestamo(objDetallePrestamo);
                i.setPubStock(i.getPubStock()-1);
                pb.modificarPublicacion(i);                
            }
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Prestamo cargado en el Sistema!",
                            ""));
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("detallePrestamo", null);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("prestamo", null);
            return "login?faces-redirect=true";
        }
        else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "La lista esta vacía",
                            "Debe prestar al menos un libro!"));
            return null;
        }
    }
    
    public String cargarLibros(){
        this.prestamo.setPreEstado(true);        
        /*System.out.println("Objeto Prestamo");
        System.out.println("Fecha Prestamo "+prestamo.getPreFechaPrestamo());
        System.out.println("Estado "+prestamo.isPreEstado());
        System.out.println("Usuario que Genera el Prestamo: "+prestamo.getPreAdministrativo());
        System.out.println("Usuario Destino del Prestamo: "+prestamo.getPreSocio());*/
        
       /* System.out.println("Fecha de Devolucion: "+dp.getDpFechaADevolver());
        System.out.println("turno: "+dp.getDpTurno());*/
        
        this.listadoAPrestar=null;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("detallePrestamo", this.dp);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("prestamo", this.prestamo);
        return "cargarLibros?faces-redirect=true";
    }
}
