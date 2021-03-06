package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Perfil;
import java.util.List;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IPerfilDAO {        
    public void add(Perfil perfil);
    public void update(Perfil perfil);
    public void delete(Perfil perfil);
    public boolean buscarPerfil(Perfil perfil);
    public Perfil obtenerPerfil(int codigoPerfilBuscado); //Obtiene el perfil de un codigo de Usuario
    public Perfil obtenerPerfilDirecto(int codigoPerfilBuscado); //Obtiene el perfil de un codigo de perfil
    public List<Perfil> listarPerfiles();
    public String obtenerNyAPerfil(int Codigobuscar);
    public String obtenerDNIPerfil(int Codigobuscar);
    

}
