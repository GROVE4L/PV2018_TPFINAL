package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Clasificacion;
import java.util.List;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IClasificacionDAO {
    public void add(Clasificacion c);
    public void update(Clasificacion c);
    public void delete(Clasificacion c);    
    public Clasificacion buscarCodigoClasificacion(int codigoBuscado);  
    public Clasificacion buscarClasificacion(Clasificacion c);
    public int obtenerCodigoClasificacion(Clasificacion c);
    public List<Clasificacion> devolverClasificaciones();
}
