package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.DetalleReserva;
import aplicacion.modelo.dominio.Publicacion;
import java.util.List;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IPublicacionDAO {
    public void add(Publicacion p);
    public void update(Publicacion p);
    public void delete(Publicacion p);
    public Publicacion buscarPublicacion(Publicacion p);
    public int obtenerCodigoPublicacion(Publicacion p);
    public List<Publicacion> devolverPublicaciones();
    public List<Publicacion> devolverPublicacionesConStock();
    public String devolverNombrePublicacion(String codigoPublicacion);
}
