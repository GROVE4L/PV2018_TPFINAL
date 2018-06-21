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
public class AgregarClasificacionFormBean implements Serializable{

    @ManagedProperty(value = "#{clasificacionBean}")
    private ClasificacionBean clasificacionBean;
    
    private Clasificacion clasificacion;
    private Clasificacion clasificacionSeleccionada;
    
    public AgregarClasificacionFormBean() {
        this.clasificacion = new Clasificacion();
        this.clasificacionSeleccionada = new Clasificacion();
    }

    public ClasificacionBean getClasificacionBean() {
        return clasificacionBean;
    }

    public void setClasificacionBean(ClasificacionBean clasificacionBean) {
        this.clasificacionBean = clasificacionBean;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Clasificacion getClasificacionSeleccionada() {
        return clasificacionSeleccionada;
    }

    public void setClasificacionSeleccionada(Clasificacion clasificacionSeleccionada) {
        this.clasificacionSeleccionada = clasificacionSeleccionada;
    }
   
    public Clasificacion buscarClasificacion() {        
        return clasificacionBean.buscarClasificacion(this.clasificacion);
    }
    public List<Clasificacion> listadoClasificaciones() {        
        return clasificacionBean.listarClasificaciones();
    }
    
    public void modificarClasificacion() {
        clasificacionBean.modificarClasificacion(clasificacionSeleccionada);
    }
    
    public void borrarClasificacion(Clasificacion c) {
        clasificacionBean.borrarClasificacion(c);
    }        
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
