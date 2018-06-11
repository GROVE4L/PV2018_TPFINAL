package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Usuario;
import java.util.List;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IUsuarioDAO{
    
    public Usuario login(Usuario usuario);
    public void add(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);
    public boolean buscarUsuario(Usuario usuario);
    public int obtenerCodigoUsuario(Usuario usuario);
    public List<Usuario> devolverUsuarios();
}
