package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.DetallePrestamoDAOImp;
import aplicacion.modelo.dominio.DetallePrestamo;
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
public class DetallePrestamoBean implements Serializable{

    private DetallePrestamo dp;
    
    public DetallePrestamoBean() {
        this.dp = new DetallePrestamo();        
    }

    public DetallePrestamo getDp() {
        return dp;
    }

    public void setDp(DetallePrestamo dp) {
        this.dp = dp;
    }
    
    public void agregarDetallePrestamo(DetallePrestamo dp) {
        DetallePrestamoDAOImp dpDAOImp = new DetallePrestamoDAOImp();
        dpDAOImp.add(dp);
    }
    public void borrarDetallePrestamo(DetallePrestamo dp) {
        DetallePrestamoDAOImp dpDAOImp = new DetallePrestamoDAOImp();
        dpDAOImp.delete(dp);
    }
    public void modificarDetallePrestamo(DetallePrestamo dp) {
        DetallePrestamoDAOImp dpDAOImp = new DetallePrestamoDAOImp();
        dpDAOImp.update(dp);
    }
    
    public List<DetallePrestamo> devolverDetallePrestamos(DetallePrestamo dp) {
        DetallePrestamoDAOImp dpDAOImp = new DetallePrestamoDAOImp();
        return dpDAOImp.devolverDetallePrestamos();
    }
    
    /*
    public void borrarAutor(Autor a) {
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
    public Autor buscarPorCodigo(int codigoBuscado) {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        return autorDAOImp.buscarCodigoAutor(codigoBuscado);
    }
            
    public List<Autor> listarAutores() {
        AutorDAOImp autorDAOImp = new AutorDAOImp();
        return autorDAOImp.devolverAutores();
    }    */
}