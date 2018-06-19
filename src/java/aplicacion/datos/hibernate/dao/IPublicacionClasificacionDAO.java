package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.PublicacionClasificacion;
import java.util.List;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IPublicacionClasificacionDAO{

    public void add(PublicacionClasificacion pc);
    public void delete(PublicacionClasificacion pc);
    public void update(PublicacionClasificacion pc);  
    public List<PublicacionClasificacion> devolverPublicacionesClasificaciones(String codigoPublicacion);
}
