package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.PublicacionAutorDAOImp;
import aplicacion.modelo.dominio.PublicacionAutor;
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
public class PublicacionAutorBean implements Serializable{
    
    public PublicacionAutorBean() {
        
    }
    public void agregarPublicacionAutor(PublicacionAutor pb) {
        PublicacionAutorDAOImp pbDAOImp = new PublicacionAutorDAOImp();
        pbDAOImp.add(pb);
    }
    
    public List<PublicacionAutor> listarPublicacionAutor(String codigoPublicacionBuscado) {
        PublicacionAutorDAOImp pbDAOImp = new PublicacionAutorDAOImp();
        return pbDAOImp.devolverPublicacionesAutores(codigoPublicacionBuscado);
    }
    
    /*public void borrarAutor(Autor a) {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        autorDAOImp.delete(a);
    }
    
    public void modificarAutor(Autor a) {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        autorDAOImp.update(a);
    }

    public Autor buscarAutor(Autor a) {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        return autorDAOImp.buscarAutor(a);
    }
    public void agregarAutor(Autor a) {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        autorDAOImp.add(a);
    }
    
    public List<Autor> listarAutores() {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        return autorDAOImp.devolverAutores();
    }*/
}