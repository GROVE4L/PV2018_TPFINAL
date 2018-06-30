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
    public List<DetallePrestamo> devolverDetallePrestamosCodigo(int codigoPrestamoBuscado) {
        DetallePrestamoDAOImp dpDAOImp = new DetallePrestamoDAOImp();
        return dpDAOImp.devolverDetallePrestamosCodigo(codigoPrestamoBuscado);
    }    
}