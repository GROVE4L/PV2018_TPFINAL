package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.ClasificacionBean;
import aplicacion.controlador.converters.Texto;
import aplicacion.modelo.dominio.Clasificacion;
import java.io.Serializable;
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
 * clase AgregarClasificacionFormBean
 */
public class AgregarClasificacionFormBean implements Serializable{

    @ManagedProperty(value = "#{clasificacionBean}")
    private ClasificacionBean clasificacionBean;
    
    private Clasificacion clasificacion;
    private Clasificacion clasificacionSeleccionada;
    
    public AgregarClasificacionFormBean() {
        this.clasificacion = new Clasificacion();
        this.clasificacionSeleccionada = new Clasificacion();
    }
    /**
     * constructor de ClasificacionBean con su get
     * @return 
     */
    public ClasificacionBean getClasificacionBean() {
        return clasificacionBean;
    }
    /**
     * constructor de ClasificacionBean con su set
     * @param clasificacionBean 
     */
    public void setClasificacionBean(ClasificacionBean clasificacionBean) {
        this.clasificacionBean = clasificacionBean;
    }
    /**
     * constructor de Clasificacion con su get
     * @return 
     */
    public Clasificacion getClasificacion() {
        return clasificacion;
    }
    /**
     * constructor de Clasificaion con su set
     * @param clasificacion 
     */
    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }
    /**
     * constructor de ClasificacionSeleccionada con su get
     * @return 
     */
    public Clasificacion getClasificacionSeleccionada() {
        return clasificacionSeleccionada;
    }
    /**
     * constructor de ClasificacionSeleccionada con su get
     * @param clasificacionSeleccionada 
     */
    public void setClasificacionSeleccionada(Clasificacion clasificacionSeleccionada) {
        this.clasificacionSeleccionada = clasificacionSeleccionada;
    }
    /**
     * busqueda de Clasificacion
     * @return 
     */
    public Clasificacion buscarClasificacion() {        
        return clasificacionBean.buscarClasificacion(this.clasificacion);
    }
    /**
     * listado de Clasificaciones
     * @return 
     */
    public List<Clasificacion> listadoClasificaciones() {        
        return clasificacionBean.listarClasificaciones();
    }
    /**
     * procedimiento modificarClasificacion 
     * modificacion de clasificacion
     */
    public void modificarClasificacion() {
        clasificacionBean.modificarClasificacion(clasificacionSeleccionada);
    }
    /**
     * procedimiento llamado borrarClasificacion
     * borrado clasificacion
     * @param c 
     */
    public void borrarClasificacion(Clasificacion c) {
        clasificacionBean.borrarClasificacion(c);
    } 
    /**
     * procedimiento llamado agregarClasificacio
     * agregado de clasificacion
     */
    public void agregarClasificacion() {
        if(this.buscarClasificacion() == null) { //No existe la clasificacion
            Texto t = new Texto();
            this.clasificacion.setClaDescripcion(t.primeraLetraMayus(this.clasificacion.getClaDescripcion()));
            
            clasificacionBean.agregarClasificacion(this.clasificacion);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Clasificacion Agregada Exitosamente",
                            ""));
            this.clasificacion = new Clasificacion();
        }
        else { //La clasificacion ya existe..
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Esta Clasificacion ya existe!",
                            ""));
        }
    }
}
