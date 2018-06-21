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
public class EditorialBean implements Serializable{

    private Editorial editorial;
    
    public EditorialBean() {
        this.editorial = new Editorial();        
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public void recuperarEditorial(Editorial e) {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        editorialDAOImp.recover(e);
    }
    
    public void borrarEditorial(Editorial e) {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        editorialDAOImp.delete(e);
    }
    
    public void modificarEditorial(Editorial e) {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        editorialDAOImp.update(e);
    }
    
    public Editorial buscarEditorial(Editorial ed) {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        return editorialDAOImp.buscarEditorial(ed);
    }
    public void agregarEditorial(Editorial ed) {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        editorialDAOImp.add(ed);
    }
    
    public String devolverNombreEditorial(int codigoBuscado) {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        return editorialDAOImp.devolverNombreEditorial(codigoBuscado);
    }
    
    public List<Editorial> listarEditoriales() {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        return editorialDAOImp.devolverEditoriales();
    }
    public List<Editorial> listarEditorialesActivas() {
        EditorialDAOImp editorialDAOImp = new EditorialDAOImp();
        return editorialDAOImp.devolverEditorialesActivas();
    }
}