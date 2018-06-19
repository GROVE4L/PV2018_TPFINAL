package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.PublicacionAutor;
import java.util.List;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IPublicacionAutorDAO{

    public void add(PublicacionAutor pb);
    public void delete(PublicacionAutor pb);
    public void update(PublicacionAutor pb);    
    public List<PublicacionAutor> devolverPublicacionesAutores(String codigoPublicacion);
}
