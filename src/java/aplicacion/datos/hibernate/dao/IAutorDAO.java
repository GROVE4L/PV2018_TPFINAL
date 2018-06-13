package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Autor;
import java.util.List;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IAutorDAO{

    public void add(Autor a);
    public void update(Autor a);
    public void delete(Autor a);
    public Autor buscarAutor(Autor a);
    public int obtenerCodigoAutor(Autor a);
    public List<Autor> devolverAutores();
}
