package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PublicacionBean;
import aplicacion.controlador.converters.Texto;
import aplicacion.modelo.dominio.Publicacion;
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
public class AgregarPublicacionFormBean implements Serializable{

    @ManagedProperty(value = "#{publicacionBean}")
    private PublicacionBean publicacionBean;
    
    private Publicacion publicacion;
    
    public AgregarPublicacionFormBean() {
        this.publicacion = new Publicacion();
        this.publicacion.setPubTipo("Libro");
    }

    public PublicacionBean getPublicacionBean() {
        return publicacionBean;
    }

    public void setPublicacionBean(PublicacionBean publicacionBean) {
        this.publicacionBean = publicacionBean;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

        
    public Publicacion buscarPublicacion() {        
        return publicacionBean.buscarPublicacion(this.publicacion);
    }
    
    public List<Publicacion> listadoPublicaciones() {        
        return publicacionBean.listarPublicaciones();
    }
  
    public List<Publicacion> listadoPublicacionesConStock() {
        return publicacionBean.listarPublicacionesConStock();
    }
    
    public void agregarPublicacion() {
        if(this.buscarPublicacion() == null) { //No existe la publicacion
            Texto t = new Texto();
            this.publicacion.setPubNombre(t.primeraLetraMayus(this.publicacion.getPubNombre())); //Primer letra del Nombre en Mayusculas
            this.publicacion.setPubTipo(t.primeraLetraMayus(this.publicacion.getPubTipo())); //Primer letra del Apellido en Mayusculas
            this.publicacion.setPubEstado(true);
            publicacionBean.agregarPublicacion(this.publicacion);
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Publicación Agregada Exitosamente",
                            ""));
            this.publicacion = new Publicacion();
        }
        else { //La publicacion ya existe..
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Este codigo de publicación ya existe!",
                            ""));
        }
    }
}
