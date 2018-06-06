package aplicacion.dao;

import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IUsuarioDAO{
    
    public Usuario login(Usuario usuario);
}
