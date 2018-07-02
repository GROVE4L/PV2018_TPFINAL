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
/**
 * crea la clase DetallePrestamoBean
 */
public class DetallePrestamoBean implements Serializable{

    private DetallePrestamo dp;
    
    public DetallePrestamoBean() {
        this.dp = new DetallePrestamo();        
    }
     /**
     * se crea el constructor de DetallePrestamo con su Get y Set
     * @return 
     */
    public DetallePrestamo getDp() {
        return dp;
    }

    public void setDp(DetallePrestamo dp) {
        this.dp = dp;
    }
     /**
      * se crea un procedimiento llamado agregarDetallePrestamo
      * @param dp 
      */
    public void agregarDetallePrestamo(DetallePrestamo dp) {
        DetallePrestamoDAOImp dpDAOImp = new DetallePrestamoDAOImp();
        dpDAOImp.add(dp);
    }
    /**
      * se crea un procedimiento llamado borrarDetallePrestamo
      * @param dp 
      */
    public void borrarDetallePrestamo(DetallePrestamo dp) {
        DetallePrestamoDAOImp dpDAOImp = new DetallePrestamoDAOImp();
        dpDAOImp.delete(dp);
    }
    /**
      * se crea un procedimiento llamado modificarDetallePrestamo
      * @param dp 
      */
    public void modificarDetallePrestamo(DetallePrestamo dp) {
        DetallePrestamoDAOImp dpDAOImp = new DetallePrestamoDAOImp();
        dpDAOImp.update(dp);
    }
     /**
     * lista de detalle prestamo
     * @param dp
     * @return 
     */
    public List<DetallePrestamo> devolverDetallePrestamos(DetallePrestamo dp) {
        DetallePrestamoDAOImp dpDAOImp = new DetallePrestamoDAOImp();
        return dpDAOImp.devolverDetallePrestamos();
    }
    /**
     * 
     * @param codigoPrestamoBuscado
     * @return 
     */
    public List<DetallePrestamo> devolverDetallePrestamosCodigo(int codigoPrestamoBuscado) {
        DetallePrestamoDAOImp dpDAOImp = new DetallePrestamoDAOImp();
        return dpDAOImp.devolverDetallePrestamosCodigo(codigoPrestamoBuscado);
    }    
}