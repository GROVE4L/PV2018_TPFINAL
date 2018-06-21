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
public class PrestamoBean implements Serializable{

    private Prestamo prestamo;
    
    public PrestamoBean() {
        this.prestamo = new Prestamo();        
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
        
    public void borrarPrestamo(Prestamo pre) {
        PrestamoDAOImp prestamoDAOImp = new PrestamoDAOImp();
        prestamoDAOImp.delete(pre);
    }
    
    public void modificarPrestamo(Prestamo pre) {
        PrestamoDAOImp prestamoDAOImp = new PrestamoDAOImp();
        prestamoDAOImp.update(pre);
    }
    public void agregarPrestamo(Prestamo pre) {
        PrestamoDAOImp prestamoDAOImp = new PrestamoDAOImp();
        prestamoDAOImp.add(pre);
    }
            
    public List<Prestamo> listarPrestamos() {
        PrestamoDAOImp prestamoDAOImp = new PrestamoDAOImp();
        return prestamoDAOImp.devolverPrestamos();
    }
    public Prestamo obtenerUltimoPrestamo() {
        PrestamoDAOImp prestamoDAOImp = new PrestamoDAOImp();
        return prestamoDAOImp.obtenerUltimoPrestamo();
    }    
}