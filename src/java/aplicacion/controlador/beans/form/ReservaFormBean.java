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
/**
 * clase ReservaFormBean
 */
public class ReservaFormBean implements Serializable{

    @ManagedProperty(value = "#{publicacionBean}")
    private PublicacionBean publicacionBean;
    
    @ManagedProperty(value = "#{reservaBean}")
    private ReservaBean reservaBean;
    
    @ManagedProperty(value = "#{detalleReservaBean}")
    private DetalleReservaBean detalleReservaBean;
    
    @ManagedProperty(value = "#{perfilBean}")
    private PerfilBean perfilBean;
    
    @ManagedProperty(value = "#{prestamoBean}")
    private PrestamoBean prestamoBean;
    
    @ManagedProperty(value = "#{detallePrestamoBean}")
    private DetallePrestamoBean detallePrestamoBean;
    
    private Prestamo prestamo;
    private DetallePrestamo dp;
    private Reserva reserva;
    private DetalleReserva dr;
    private DetalleReserva drProvisorio;
    private List<Publicacion> listadoAPrestar;
    
    public ReservaFormBean() {
        this.reserva = new Reserva();
        this.dr = new DetalleReserva();
        this.drProvisorio = new DetalleReserva();
        this.prestamo = new Prestamo();
        this.dp = new DetallePrestamo();
        dp.setDpTurno("Mañana");
        this.listadoAPrestar = new ArrayList<Publicacion>();
    }

    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
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

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public DetallePrestamo getDp() {
        return dp;
    }

    public void setDp(DetallePrestamo dp) {
        this.dp = dp;
    }
    
    /**
     * constructor de ListadoAPrestar con su get
     * @return 
     */
    public List<Publicacion> getListadoAPrestar() {
        return listadoAPrestar;
    }
    /**
     * constructor de ListadoAPrestar con su set
     * @param listadoAPrestar 
     */
    public void setListadoAPrestar(List<Publicacion> listadoAPrestar) {
        this.listadoAPrestar = listadoAPrestar;
    }    
    /**
     * constructor de ReservaBean con su get
     * @return 
     */
    public ReservaBean getReservaBean() {
        return reservaBean;
    }
    /**
     * constructor de ReservaBean con su set
     * @param reservaBean 
     */
    public void setReservaBean(ReservaBean reservaBean) {
        this.reservaBean = reservaBean;
    }
    /**
     * constructor de DetalleReservaBean con su get
     * @return 
     */
    public DetalleReservaBean getDetalleReservaBean() {
        return detalleReservaBean;
    }
    /**
     * constructor de DetalleReservaBean con su set
     * @param detalleReservaBean 
     */
    public void setDetalleReservaBean(DetalleReservaBean detalleReservaBean) {
        this.detalleReservaBean = detalleReservaBean;
    }   
    /**
     * constructor de Reserva con su get
     * @return 
     */
    public Reserva getReserva() {
        return reserva;
    }
    /**
     * constructor de Reserva con su set
     * @param reserva 
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    /**
     * constructor de Dr con su get
     * @return 
     */
    public DetalleReserva getDr() {
        return dr;
    }
    /**
     * constructor de Dr con su set
     * @param dr 
     */
    
    
    public void setDr(DetalleReserva dr) {
        this.dr = dr;
    }

    public PublicacionBean getPublicacionBean() {
        return publicacionBean;
    }

    public void setPublicacionBean(PublicacionBean publicacionBean) {
        this.publicacionBean = publicacionBean;
    }

    public DetalleReserva getDrProvisorio() {
        return drProvisorio;
    }

    public void setDrProvisorio(DetalleReserva drProvisorio) {
        this.drProvisorio = drProvisorio;
    }
    
    
    /**
     * procedimiento llamado quitarDeLista
     * 
     * @param pu 
     */
    public void quitarDeLista(Publicacion pu) {
        System.out.println("Quitado (?");
        this.listadoAPrestar.remove(pu);
    }
    /**
     * procedimiento llamado agregarALista
     * @param pu 
     */
    public void agregarALista(Publicacion pu) {
        this.listadoAPrestar.add(pu);        
    }
    /**
     * obtiene el obj reserva
     * @return 
     */
    public Reserva obtenerObjReserva() {
        return (Reserva) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("reserva");
    }
    /**
     * obtiene el obj detalle de reserva
     * @return 
     */
    public DetalleReserva obtenerObjDetalleReserva() {
        return (DetalleReserva) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("detalleReserva");
    }
    /**
     * funcion que obtiene nombres de sesion
     * @return 
     */
    public String obtenerNombreSesion(){        
        LoginFormBean lfm = new LoginFormBean();
        Perfil pf = lfm.obtenerPerfilSesion();
        return pf.getPerNombres()+" "+pf.getPerApellidos();
    }
    /**
     * Funcion  que finaliza y guarda la reserva.
     * @return Devuelve nada
     */
    public String finalizarReserva(){
        if(!this.listadoAPrestar.isEmpty()){
            Reserva objReserva = this.obtenerObjReserva();
            DetalleReserva objDetalleReserva = this.obtenerObjDetalleReserva();
            reservaBean.agregarReserva(objReserva);
            
            objDetalleReserva.setDrevEstado(true);            
            objDetalleReserva.setDrevCantidad(1);
            objDetalleReserva.setDrevReserva(reservaBean.obtenerUltimaReserva().getRevCodigo());

            PublicacionBean pb = new PublicacionBean();
            for(Publicacion i: this.listadoAPrestar) {
                objDetalleReserva.setDrevPublicacion(i.getPubCodigo());
                detalleReservaBean.agregarDetalleReserva(objDetalleReserva);                
            }
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Reserva Cargada en el sistema cargado en el Sistema!",
                            ""));
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("detalleReserva", null);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("reserva", null);
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
    /**
     * funcion que carga los libros
     * @return 
     */
    public String cargarLibros(){
        LoginFormBean lfm = new LoginFormBean();
        this.reserva.setRevEstado(true);
        this.reserva.setRevFechaEmision(new Date());
        this.reserva.setRevPerfil(lfm.obtenerPerfilSesion().getPerCodigo());        
        
        this.listadoAPrestar=null;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("detalleReserva", this.dr);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("reserva", this.reserva);
        return "cargarReservaLibros?faces-redirect=true";
    }
    
    /**
     * listado de Detalle Reserva
     * @return 
     */
    public List<DetalleReserva> listadoDetalleReserva() {        
        return detalleReservaBean.devolverDetalleReserva();
    }
    
    /**
     * obtiene el obj de prestamo
     * @return 
     */
    public Prestamo obtenerObjPrestamo() {
        return (Prestamo) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("prestamo");
    }
    /**
     * obtiene el obj de detalle prestamo
     * @return 
     */
    public DetallePrestamo obtenerObjDetallePrestamo() {
        return (DetallePrestamo) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("detallePrestamo");
    }
    public String obtenerNombrePublicacion(String CodigoBuscar){
        return publicacionBean.buscarNombrePublicacion(CodigoBuscar);
    }
    
    public Date obtenerFechaReserva(int CodigoBuscar){
        return reservaBean.obtenerFechaReserva(CodigoBuscar);
    }
    
    public int obtenerCodigoPerfil(int CodigoBuscar){
        return reservaBean.obtenerCodigoPerfil(CodigoBuscar);
    }
    
    public String obtenerNyAPerfil(){
        return perfilBean.obtenerNyAPerfil(reservaBean.obtenerCodigoPerfil(this.drProvisorio.getDrevReserva()));
                
    }
    
    public String cargarLibrosAPrestamos(){
        this.prestamo.setPreSocio(reservaBean.obtenerCodigoPerfil(this.drProvisorio.getDrevReserva()));
        this.prestamo.setPreEstado(true);        
        this.listadoAPrestar=null;
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("detallePrestamo", this.dp);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("prestamo", this.prestamo);
       
        Prestamo objPrestamo = this.obtenerObjPrestamo();
        DetallePrestamo objDetallePrestamo = this.obtenerObjDetallePrestamo();
        prestamoBean.agregarPrestamo(objPrestamo);

        objDetallePrestamo.setDpEstado(true);
        objDetallePrestamo.setDpFechaDevolucion(new Date(1999, 9, 9));
        objDetallePrestamo.setDpPrestamo(prestamoBean.obtenerUltimoPrestamo().getPreCodigo());

        PublicacionBean pb = new PublicacionBean();
        //for (Publicacion i : this.listadoAPrestar) {
            objDetallePrestamo.setDpPublicacion(this.drProvisorio.getDrevPublicacion());
            detallePrestamoBean.agregarDetallePrestamo(objDetallePrestamo);
            
            //i.setPubStock(i.getPubStock() - 1);
            //pb.modificarPublicacion(i);
        //}

        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Prestamo cargado en el Sistema!",
                ""));

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("detallePrestamo", null);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("prestamo", null);
        return "login?faces-redirect=true";
    }
}
