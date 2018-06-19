package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.AutorBean;
import aplicacion.controlador.converters.Texto;
import aplicacion.modelo.dominio.Autor;
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
public class AgregarAutorFormBean implements Serializable{

    @ManagedProperty(value = "#{autorBean}")
    private AutorBean autorBean;
    
    private Autor autor;
    private Autor autorSeleccionado;
    
    public AgregarAutorFormBean() {
        this.autor = new Autor();
        this.autorSeleccionado = new Autor();
    }

    public Autor getAutorSeleccionado() {
        return autorSeleccionado;
    }

    public void setAutorSeleccionado(Autor autorSeleccionado) {
        this.autorSeleccionado = autorSeleccionado;
    }
    
    
    
    public AutorBean getAutorBean() {
        return autorBean;
    }

    public void setAutorBean(AutorBean autorBean) {
        this.autorBean = autorBean;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }  
    
    public Autor buscarAutor() {        
        return autorBean.buscarAutor(this.autor);
    }
    public List<Autor> listadoAutores() {        
        return autorBean.listarAutores();
    }
    
    public void modificarAutor() {
        autorBean.modificarAutor(autorSeleccionado);
    }
    
    public void borrarAutor(Autor a) {
        autorBean.borrarAutor(a);
    }
           
    public void agregarAutor() {
        if(this.buscarAutor() == null) { //No existe el autor             
            Texto t = new Texto();
            this.autor.setAutNombres(t.primeraLetraMayus(this.autor.getAutNombres())); //Primer letra del Nombre en Mayusculas
            this.autor.setAutApellidos(t.primeraLetraMayus(this.autor.getAutApellidos())); //Primer letra del Apellido en Mayusculas
            autorBean.agregarAutor(autor);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Autor Agregada Exitosamente",
                            ""));
        }
        else { //La editorial ya existe..
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Este Autor ya existe!",
                            ""));
        }
    }
}
