package aplicacion.dao;

import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;
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
    public List<Usuario> devolverUsuarios();
}
