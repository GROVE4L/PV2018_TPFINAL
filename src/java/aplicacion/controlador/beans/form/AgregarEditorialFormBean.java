package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.EditorialBean;
import aplicacion.controlador.converters.Texto;
import aplicacion.modelo.dominio.Editorial;
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
public class AgregarEditorialFormBean implements Serializable{

    @ManagedProperty(value = "#{editorialBean}")
    private EditorialBean editorialBean;
    
    private Editorial editorial;
    private Editorial editorialSeleccionada;
    
    public AgregarEditorialFormBean() {
        this.editorial = new Editorial();
        this.editorialSeleccionada = new Editorial();
    }

    public Editorial getEditorialSeleccionada() {
        return editorialSeleccionada;
    }

    public void setEditorialSeleccionada(Editorial editorialSeleccionada) {
        this.editorialSeleccionada = editorialSeleccionada;
    }
    
    public EditorialBean getEditorialBean() {
        return editorialBean;
    }

    public void setEditorialBean(EditorialBean editorialBean) {
        this.editorialBean = editorialBean;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    public void modificarEditorial() {
        editorialBean.modificarEditorial(editorialSeleccionada);
    }
    
    public void recuperarEditorial(Editorial e) {
        e.setEditEstado(true);
        editorialBean.recuperarEditorial(e);
    }
    
    public void borrarEditorial(Editorial e) {
        e.setEditEstado(false);
        editorialBean.borrarEditorial(e);
    }
    
    public Editorial buscarEditorial() {        
        return editorialBean.buscarEditorial(this.editorial);
    }
    
    public List<Editorial> listadoEditoriales() {        
        return editorialBean.listarEditoriales();
    }
        
    public void agregarEditorial() {      
        if(this.buscarEditorial() == null) { //No existe la editorial..            
            this.editorial.setEditEstado(true);
            Texto t = new Texto();
            this.editorial.setEditNombre(t.primeraLetraMayus(this.editorial.getEditNombre()));           
            editorialBean.agregarEditorial(editorial);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Editorial Agregada Exitosamente",
                            ""));
        }
        else { //La editorial ya existe..
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Esta editoral ya existe!",
                            ""));
        }
    }
}
