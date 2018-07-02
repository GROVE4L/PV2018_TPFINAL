package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.EditorialDAOImp;
import aplicacion.modelo.dominio.Editorial;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rojas, Guido G.
 */
@ManagedBean
@ViewScoped
/**
 * crea la clase EditorialBean 
 */
public class EditorialBean implements Serializable{

    private Editorial editorial;
    
    public EditorialBean() {
        this.editorial = new Editorial();        
    }
    /**
     * se crea el constructor de Editorial con su Get y Set
     * @return 
     */
    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    /**
      * se crea un procedimiento llamado recuperarEditorial en el cual se podra recuperar el Editorial
      * @param e 
      */
    public void recuperarEditorial(Editorial e) {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        editorialDAOImp.recover(e);
    }
     /**
      * se crea un procedimiento llamado borrarEditorial en el cual se podra borrar el Editorial
      * @param e 
      */
    public void borrarEditorial(Editorial e) {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        editorialDAOImp.delete(e);
    }
    /**
      * se crea un procedimiento llamado modificarEditorial en el cual se podra modificar el Editorial
      * @param e 
      */
    public void modificarEditorial(Editorial e) {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        editorialDAOImp.update(e);
    }
    /**
     * busqueda de Editorial
     * @param ed
     * @return 
     */
    public Editorial buscarEditorial(Editorial ed) {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        return editorialDAOImp.buscarEditorial(ed);
    }
    /**
     * Agregado de Editorial
     * @param ed 
     */
    public void agregarEditorial(Editorial ed) {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        editorialDAOImp.add(ed);
    }
    /**
     * devolucion del nombre de Editorial
     * @param codigoBuscado
     * @return 
     */
    public String devolverNombreEditorial(int codigoBuscado) {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        return editorialDAOImp.devolverNombreEditorial(codigoBuscado);
    }
    /**
     * lista de Editoriales
     * @return 
     */
    public List<Editorial> listarEditoriales() {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        return editorialDAOImp.devolverEditoriales();
    }
    /**
     * lista de Editoriales Activas
     * @return 
     */
    public List<Editorial> listarEditorialesActivas() {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        return editorialDAOImp.devolverEditorialesActivas();
    }
}