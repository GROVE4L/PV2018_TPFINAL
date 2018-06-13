package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.AutorDAOImp;
import aplicacion.modelo.dominio.Autor;
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
public class AutorBean implements Serializable{

    private Autor autor;
    
    public AutorBean() {
        this.autor = new Autor();        
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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
    }
}