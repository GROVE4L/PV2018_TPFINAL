package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Prestamo;
import java.util.List;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IPrestamoDAO{

    public void add(Prestamo pre);
    public void update(Prestamo pre);
    public void delete(Prestamo pre);
    public List<Prestamo> devolverPrestamos();
    public Prestamo obtenerUltimoPrestamo();
}
