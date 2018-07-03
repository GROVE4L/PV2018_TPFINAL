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
/**
 * clase AgregarEditorialFormBean
 */
public class AgregarEditorialFormBean implements Serializable{

    @ManagedProperty(value = "#{editorialBean}")
    private EditorialBean editorialBean;
    
    private Editorial editorial;
    private Editorial editorialSeleccionada;
    /**
     * 
     */
    public AgregarEditorialFormBean() {
        this.editorial = new Editorial();
        this.editorialSeleccionada = new Editorial();
    }
    /**
     * constructor de Editorial seleccionada con su get
     * @return 
     */
    public Editorial getEditorialSeleccionada() {
        return editorialSeleccionada;
    }
    /**
     * constructor de Editorial seleccionada con su set
     * @param editorialSeleccionada 
     */
    public void setEditorialSeleccionada(Editorial editorialSeleccionada) {
        this.editorialSeleccionada = editorialSeleccionada;
    }
    /**
     * constructor de EditorialBean con su get
     * @return 
     */
    public EditorialBean getEditorialBean() {
        return editorialBean;
    }
    /**
     * constructor de EditorialBean con su set
     * @param editorialBean 
     */
    public void setEditorialBean(EditorialBean editorialBean) {
        this.editorialBean = editorialBean;
    }
    /**
     * constructor de Editorial con su get
     * @return 
     */
    public Editorial getEditorial() {
        return editorial;
    }
    /**
     * constructor de Editorial con su set
     * @param editorial 
     */
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    /**
     * procedimiento llamado modificarEditorial
     * modificacin de Editorial
     */
    public void modificarEditorial() {
        editorialBean.modificarEditorial(editorialSeleccionada);
    }
    /**
     * procedimiento recuperarEditorial
     * recuperacion de Editorial
     * @param e 
     */
    public void recuperarEditorial(Editorial e) {
        e.setEditEstado(true);
        editorialBean.recuperarEditorial(e);
    }
    /**
     * procedimiento borrarEditorial
     * borrado de Editorial
     * @param e 
     */
    public void borrarEditorial(Editorial e) {
        e.setEditEstado(false);
        editorialBean.borrarEditorial(e);
    }
    /**
     * busqueda de Editorail
     * @return 
     */
    public Editorial buscarEditorial() {        
        return editorialBean.buscarEditorial(this.editorial);
    }
    /**
     * devuelve el nombre de Editorial
     * @param codigobuscado
     * @return 
     */
    public String devolverNombreEditorial(int codigobuscado) {
        return editorialBean.devolverNombreEditorial(codigobuscado);
    }
    /**
     * lista de Editoriales
     * @return 
     */
    public List<Editorial> listadoEditoriales() {        
        return editorialBean.listarEditoriales();
    }
    /**
     * listado Editoriales Activas
     * @return 
     */
    public List<Editorial> listadoEditorialesActivas() {        
        return editorialBean.listarEditorialesActivas();
    }
    /**
     * agregado de Editorial
     */   
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
            this.editorial= new Editorial();
        }
        else { //La editorial ya existe..
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Esta editoral ya existe!",
                            ""));
        }
    }
}
