package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.PrestamoDAOImp;
import aplicacion.modelo.dominio.Prestamo;
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
 * clase llamada PrestamoBean
 */
public class PrestamoBean implements Serializable{

    private Prestamo prestamo;
    
    public PrestamoBean() {
        this.prestamo = new Prestamo();        
    }
    /**
     * se crea el constructor de Prestamo con su Get y Set
     * @return prestamo
     */
    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
     /**
     *  procedimiento llamado borarrPrestamo
     * en el cual se borra el Prestamo
     * @param pre 
     */     
    public void borrarPrestamo(Prestamo pre) {
        PrestamoDAOImp prestamoDAOImp = new PrestamoDAOImp();
        prestamoDAOImp.delete(pre);
    }
    /**
     * un procedimiento llamado modificarPrestamo
     * en el cual se modifica el Prestamo
     * @param pre 
     */
    public void modificarPrestamo(Prestamo pre) {
        PrestamoDAOImp prestamoDAOImp = new PrestamoDAOImp();
        prestamoDAOImp.update(pre);
    }
    /**
     * procedimiento llamado agregarPrestamo
     * agregado de Prestamo
     * @param pre 
     */
    public void agregarPrestamo(Prestamo pre) {
        PrestamoDAOImp prestamoDAOImp = new PrestamoDAOImp();
        prestamoDAOImp.add(pre);
    }
    /**
       * lista de Prestamo
       * @return 
       */       
    public List<Prestamo> listarPrestamos() {
        PrestamoDAOImp prestamoDAOImp = new PrestamoDAOImp();
        return prestamoDAOImp.devolverPrestamos();
    }
     /**
     * obtener ultimo prestamo
     * @return 
     */
    public Prestamo obtenerUltimoPrestamo() {
        PrestamoDAOImp prestamoDAOImp = new PrestamoDAOImp();
        return prestamoDAOImp.obtenerUltimoPrestamo();
    }    
}