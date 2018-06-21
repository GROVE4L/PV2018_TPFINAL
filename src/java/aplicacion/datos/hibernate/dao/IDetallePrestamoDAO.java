package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.DetallePrestamo;
import java.util.List;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IDetallePrestamoDAO{

    public void add(DetallePrestamo dp);
    public void delete(DetallePrestamo dp);
    public void update(DetallePrestamo dp);    
    public List<DetallePrestamo> devolverDetallePrestamos();
}
