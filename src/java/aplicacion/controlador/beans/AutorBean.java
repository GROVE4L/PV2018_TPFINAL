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
/**
 * se crea una clase AutorBean
 */
public class AutorBean implements Serializable{

    private Autor autor;
    
    public AutorBean() {
        this.autor = new Autor();        
    }
    /**
     * se crea el constructor de Autos con su Get y Set
     * @return autor
     */
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
     /**
     * procedimiento llamado borrarAutor en el cual se podra borrar un Autor
     * @param a 
     */
    public void borrarAutor(Autor a) {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        autorDAOImp.delete(a);
    }
     /**
      * procedimiento llamado modificarAutor en el cual se podra modificar el Autor
      * @param a 
      */
    public void modificarAutor(Autor a) {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        autorDAOImp.update(a);
    }
    /**
     * busqueda de Autor
     * @param a
     * @return 
     */
    public Autor buscarAutor(Autor a) {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        return autorDAOImp.buscarAutor(a);
    }
     /**
      * se crea un procedimiento llamado agregarAutor en el cual se podra agregar el Autor
      * @param a 
      */
    public void agregarAutor(Autor a) {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        autorDAOImp.add(a);
    }
    public Autor buscarPorCodigo(int codigoBuscado) {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        return autorDAOImp.buscarCodigoAutor(codigoBuscado);
    }
            
    public List<Autor> listarAutores() {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        return autorDAOImp.devolverAutores();
    }    
}