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
/**
 * clase AgregarAutorFormBean
 */
public class AgregarAutorFormBean implements Serializable{

    @ManagedProperty(value = "#{autorBean}")
    private AutorBean autorBean;
    
    private Autor autor;
    private Autor autorSeleccionado;
    /**
     * 
     */
    public AgregarAutorFormBean() {
        this.autor = new Autor();
        this.autorSeleccionado = new Autor();
    }
    /**
     * constructor de AutorSeleccionado con su get
     * @return 
     */
    public Autor getAutorSeleccionado() {
        return autorSeleccionado;
    }
    /**
     * constructor de AutorSeleccionado con su set
     * @param autorSeleccionado 
     */
    public void setAutorSeleccionado(Autor autorSeleccionado) {
        this.autorSeleccionado = autorSeleccionado;
    }
    
    /**
     * constructor de AutorBean con su get
     * @return 
     */
    
    public AutorBean getAutorBean() {
        return autorBean;
    }
    /**
     * constructor de AutorBean con su set
     * @param autorBean 
     */
    public void setAutorBean(AutorBean autorBean) {
        this.autorBean = autorBean;
    }
    /**
     * constructor de Autor con su get
     * @return 
     */
    public Autor getAutor() {
        return autor;
    }
    /**
     * constructor de Autor con su set
     * @param autor 
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }  
    /**
     * busqueda de Autor
     * @return 
     */
    public Autor buscarAutor() {        
        return autorBean.buscarAutor(this.autor);
    }
    /**
     * listado de autores
     * @return 
     */
    public List<Autor> listadoAutores() {        
        return autorBean.listarAutores();
    }
    /**
     * modificacion de autor
     */
    public void modificarAutor() {
        autorBean.modificarAutor(autorSeleccionado);
    }
    /**
     * borrado de autor
     * @param a 
     */
    public void borrarAutor(Autor a) {
        autorBean.borrarAutor(a);
    }
     /**
      * agregado de autor
      */      
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
            this.autor=new Autor();
        }
        else { //La editorial ya existe..
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Este Autor ya existe!",
                            ""));
        }
    }
}
