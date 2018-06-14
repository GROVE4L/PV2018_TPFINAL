package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Editorial;
import java.util.List;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IEditorialDAO {
    public void add(Editorial editorial);
    public void update(Editorial editorial);
    public void delete(Editorial editorial);
    public void recover(Editorial editorial);
    public Editorial buscarEditorial(Editorial editorial);
    public List<Editorial> devolverEditoriales();
}
